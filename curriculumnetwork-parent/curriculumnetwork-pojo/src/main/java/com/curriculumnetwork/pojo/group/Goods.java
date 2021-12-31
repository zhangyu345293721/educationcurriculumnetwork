package com.curriculumnetwork.pojo.group;

import java.io.Serializable;
import java.util.List;

import com.curriculumnetwork.pojo.TbGoods;
import com.curriculumnetwork.pojo.TbGoodsDesc;
import com.curriculumnetwork.pojo.TbItem;

/**
 * 课程网的组合实体类
 *
 * @author zhangyu
 */

public class Goods implements Serializable {

    private TbGoods goods; // 课程网信息
    private TbGoodsDesc goodsDesc; // 课程网扩展信息

    private List<TbItem> itemList; // SKU的列表信息

    public TbGoods getGoods() {
        return goods;
    }

    public void setGoods(TbGoods goods) {
        this.goods = goods;
    }

    public TbGoodsDesc getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(TbGoodsDesc goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    public List<TbItem> getItemList() {
        return itemList;
    }

    public void setItemList(List<TbItem> itemList) {
        this.itemList = itemList;
    }


}
