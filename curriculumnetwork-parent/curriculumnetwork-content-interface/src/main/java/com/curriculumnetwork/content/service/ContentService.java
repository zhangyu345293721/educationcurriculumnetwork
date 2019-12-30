package com.curriculumnetwork.content.service;
import java.util.List;

import com.curriculumnetwork.pojo.TbContent;

import entity.PageResult;
/**
 * 服务层接口
 * @author zhangyu
 *
 */
public interface ContentService {

	/**
	 * 返回全部列表
	 */
	public List<TbContent> findAll();
	
	
	/**
	 * 返回分页列表
	 */
	public PageResult findPage(int pageNum,int pageSize);
	
	
	/**
	 * 增加
	*/
	public void add(TbContent content);
	
	
	/**
	 * 修改
	 */
	public void update(TbContent content);
	

	/**
	 * 根据ID获取实体
	 */
	public TbContent findOne(Long id);
	
	
	/**
	 * 批量删除
	 */
	public void delete(Long [] ids);

	/**
	 * 分页
	 */
	public PageResult findPage(TbContent content, int pageNum,int pageSize);
	
	/**
	 * 根据广告分类ID查询广告
	 */
	public List<TbContent> findByCategoryId(Long categoryId);
	
}
