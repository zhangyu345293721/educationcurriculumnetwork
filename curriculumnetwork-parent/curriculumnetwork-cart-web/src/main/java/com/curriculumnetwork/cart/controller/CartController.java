package com.curriculumnetwork.cart.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.curriculumnetwork.cart.service.CartService;
import com.curriculumnetwork.pojo.group.Cart;

import entity.Result;

/**
 * 购物车提供服务类
 *
 * @author:zhangyu
 */
@RestController
@RequestMapping("/cart")
public class CartController {

    @Reference(timeout = 6000)
    private CartService cartService;
    @Autowired
    private HttpServletRequest request;

    @Autowired
    private HttpServletResponse response;

    private static Logger logger = LoggerFactory.getLogger(DefaultBinSuggestionAlgorithm.class);


    @RequestMapping("/findCartList")
    public List<Cart> findCartList() {
        //当前登录人账号
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        logger.info("当前登录人：" + username);

        String cartListString = util.CookieUtil.getCookieValue(request, "cartList", "UTF-8");
        if (cartListString == null || cartListString.equals("")) {
            cartListString = "[]";
        }
        List<Cart> cartList_cookie = JSON.parseArray(cartListString, Cart.class);

        if (username.equals("anonymousUser")) {//如果未登录
            //从cookie中提取购物车
            logger.info("从cookie中提取购物车");
            return cartList_cookie;
        } else {//如果已登录
            //获取redis购物车
            List<Cart> cartList_redis = cartService.findCartListFromRedis(username);
            if (cartList_cookie.size() > 0) {//判断当本地购物车中存在数据
                List<Cart> cartList = cartService.mergeCartList(cartList_cookie, cartList_redis);
                cartService.saveCartListToRedis(username, cartList);
                util.CookieUtil.deleteCookie(request, response, "cartList");
                logger.info("执行了合并购物车的逻辑");
                return cartList;
            }
            return cartList_redis;
        }
    }

    @RequestMapping("/addGoodsToCartList")
    @CrossOrigin(origins = "http://localhost:9105")
    public Result addGoodsToCartList(Long itemId, Integer num) {
        //当前登录人账号
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        logger.info("当前登录人：" + name);
        try {
            List<Cart> cartList = findCartList();
            cartList = cartService.addGoodsToCartList(cartList, itemId, num);
            if (name.equals("anonymousUser")) {
                String cartListString = JSON.toJSONString(cartList);
                util.CookieUtil.setCookie(request, response, "cartList", cartListString, 3600 * 24, "UTF-8");
                logger.info("向cookie存储购物车");
            } else {//如果登录
                cartService.saveCartListToRedis(name, cartList);
            }
            return new Result(true, "存入购物车成功");
        } catch (Exception e) {
            logger.info(e.getMessage());
            return new Result(false, "存入购物车失败");
        }
    }
}
