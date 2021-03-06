package com.curriculumnetwork.cart.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.dubbo.config.annotation.Reference;
import com.curriculumnetwork.pojo.TbOrder;
import com.curriculumnetwork.order.service.OrderService;

import entity.PageResult;
import entity.Result;

/**
 * controller
 *
 * @author zhangyu
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    private static Logger logger = LoggerFactory.getLogger(DefaultBinSuggestionAlgorithm.class);

    @Reference
    private OrderService orderService;

    /**
     * 返回全部列表
     *
     */
    @RequestMapping("/findAll")
    public List<TbOrder> findAll() {
        return orderService.findAll();
    }


    /**
     * 返回全部列表
     */
    @RequestMapping("/findPage")
    public PageResult findPage(int page, int rows) {
        return orderService.findPage(page, rows);
    }

    /**
     * 增加订单
     *
     * @param order 订单
     * @return 结果
     */
    @RequestMapping("/add")
    public Result add(@RequestBody TbOrder order) {

        //获取当前登录人账号
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        order.setUserId(username);
        order.setSourceType("2");//订单来源  PC

        try {
            orderService.add(order);
            return new Result(true, "增加成功");
        } catch (Exception e) {
            logger.info(e.getMessage());
            return new Result(false, "增加失败");
        }
    }

    /**
     * 更新订单
     *
     * @param order 订单
     * @return 结果集
     */
    @RequestMapping("/update")
    public Result update(@RequestBody TbOrder order) {
        try {
            orderService.update(order);
            return new Result(true, "修改成功");
        } catch (Exception e) {
            logger.info(e.getMessage());
            return new Result(false, "修改失败");
        }
    }

    /**
     * 获取实体
     *
     * @param id id标识码
     * @return 根据id获取实体
     */
    @RequestMapping("/findOne")
    public TbOrder findOne(Long id) {
        return orderService.findOne(id);
    }

    /**
     * 批量删除
     *
     * @param ids id数组
     * @return 结果
     */
    @RequestMapping("/delete")
    public Result delete(Long[] ids) {
        try {
            orderService.delete(ids);
            return new Result(true, "删除成功");
        } catch (Exception e) {
            logger.info(e.getMessage());
            return new Result(false, "删除失败");
        }
    }

    /**
     * 查询+分页
     *
     * @param order 订单
     * @param page  页码
     * @param rows  行数
     * @return 页码集
     */
    @RequestMapping("/search")
    public PageResult search(@RequestBody TbOrder order, int page, int rows) {
        return orderService.findPage(order, page, rows);
    }
}
