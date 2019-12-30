package com.curriculumnetwork.content.service;
import java.util.List;
import com.curriculumnetwork.pojo.TbContentCategory;

import entity.PageResult;
/**
 * 服务层接口
 * @author: zhangyu
 *
 */
public interface ContentCategoryService {

	/**
	 * 返回全部列表
	 */
	public List<TbContentCategory> findAll();
	
	
	/**
	 * 返回分页列表
	 */
	public PageResult findPage(int pageNum,int pageSize);
	
	
	/**
	 * 增加
	*/
	public void add(TbContentCategory contentCategory);
	
	
	/**
	 * 修改
	 */
	public void update(TbContentCategory contentCategory);
	

	/**
	 * 根据ID获取实体
	 */
	public TbContentCategory findOne(Long id);
	
	
	/**
	 * 批量删除
	 */
	public void delete(Long [] ids);

	/**
	 * 分页
	 */
	public PageResult findPage(TbContentCategory contentCategory, int pageNum,int pageSize);
	
}
