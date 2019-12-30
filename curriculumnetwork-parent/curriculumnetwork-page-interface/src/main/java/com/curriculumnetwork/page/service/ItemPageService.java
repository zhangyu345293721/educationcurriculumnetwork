package com.curriculumnetwork.page.service;

/**
 * 商品页面服务
 *
 * @author : zhangyu
 */
public interface ItemPageService {

    /**
     * 生成课程网详细页
     *
     * @param goodsId 商品id信息
     * @return 布尔值
     */
    public boolean genItemHtml(Long goodsId);

    /**
     * 删除课程网详细页
     *
     * @param goodsIds 商品id信息
     * @return 布尔值
     */
    public boolean deleteItemHtml(Long[] goodsIds);

}
