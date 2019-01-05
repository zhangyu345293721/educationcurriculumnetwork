package com.curriculumnetwork.page.service;

public interface ItemPageService {

	/**
	 * 生成课程网详细页
	 * @param goodsId
	 * @return
	 */
	public boolean genItemHtml(Long goodsId);
	
	/**
	 * 删除课程网详细页
	 * @param goodsIds
	 * @return
	 */
	public boolean deleteItemHtml(Long [] goodsIds);
	
}
