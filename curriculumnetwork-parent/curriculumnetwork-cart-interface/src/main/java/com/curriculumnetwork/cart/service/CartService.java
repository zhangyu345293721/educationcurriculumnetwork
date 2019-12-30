package com.curriculumnetwork.cart.service;

import java.util.List;

import com.curriculumnetwork.pojo.group.Cart;

/**
 * 购物车服务接口
 * @author zhangyu
 *
 */
public interface CartService {

	/**
	 * 添加课程网到购物车
	 * @param cartList 购物车链表
	 * @param itemId   商品id
	 * @param num	   数量
	 * @return	   课程链表
	 */
	public List<Cart> addGoodsToCartList(List<Cart> cartList,Long itemId,Integer num);
	
	/**
	 * 从redis中提取购物车列表
	 * @param username 用户名
	 * @return  用户的购物车
	 */
	public List<Cart> findCartListFromRedis(String username);
	
	/**
	 * 将购物车列表存入redis
	 * @param username  用户名
	 * @param cartList  购物车信息	
	 */
	public void saveCartListToRedis(String username,List<Cart> cartList);
	
	/**
	 * 合并购物车
	 * @param cartList1 购物车1
	 * @param cartList2 购物车2
	 * @return  合并之后购物车
	 */
	public List<Cart> mergeCartList(List<Cart> cartList1,List<Cart> cartList2);
	 
}
