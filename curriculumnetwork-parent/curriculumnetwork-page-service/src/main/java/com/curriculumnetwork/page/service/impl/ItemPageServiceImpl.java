package com.curriculumnetwork.page.service.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.curriculumnetwork.mapper.TbGoodsDescMapper;
import com.curriculumnetwork.mapper.TbGoodsMapper;
import com.curriculumnetwork.mapper.TbItemCatMapper;
import com.curriculumnetwork.mapper.TbItemMapper;
import com.curriculumnetwork.page.service.ItemPageService;
import com.curriculumnetwork.pojo.TbGoods;
import com.curriculumnetwork.pojo.TbGoodsDesc;
import com.curriculumnetwork.pojo.TbItem;
import com.curriculumnetwork.pojo.TbItemExample;
import com.curriculumnetwork.pojo.TbItemExample.Criteria;

import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateNotFoundException;

/*
 * 课程网服务表
 * @author: zhangyu
 */
@Service
public class ItemPageServiceImpl implements ItemPageService {
    private static Logger logger = LoggerFactory.getLogger(ItemPageServiceImpl.class);

    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;

    @Value("${pagedir}")
    private String pagedir;

    @Autowired
    private TbGoodsMapper goodsMapper;

    @Autowired
    private TbGoodsDescMapper goodsDescMapper;

    @Autowired
    private TbItemCatMapper itemCatMapper;

    @Autowired
    private TbItemMapper itemMapper;

    @Override
    public boolean genItemHtml(Long goodsId) {

        Configuration configuration = freeMarkerConfigurer.getConfiguration();

        try {
            Template template = configuration.getTemplate("item.ftl");
            // 创建数据模型
            Map dataModel = new HashMap<>();
            // 1.课程网主表数据
            TbGoods goods = goodsMapper.selectByPrimaryKey(goodsId);
            dataModel.put("goods", goods);
            // 2.课程网扩展表数据
            TbGoodsDesc goodsDesc = goodsDescMapper.selectByPrimaryKey(goodsId);
            dataModel.put("goodsDesc", goodsDesc);
            // 3.读取课程网分类

            String itemCat1 = itemCatMapper.selectByPrimaryKey(
                    goods.getCategory1Id()).getName();
            String itemCat2 = itemCatMapper.selectByPrimaryKey(
                    goods.getCategory2Id()).getName();
            String itemCat3 = itemCatMapper.selectByPrimaryKey(
                    goods.getCategory3Id()).getName();
            dataModel.put("itemCat1", itemCat1);
            dataModel.put("itemCat2", itemCat2);
            dataModel.put("itemCat3", itemCat3);

            // 4.读取SKU列表
            TbItemExample example = new TbItemExample();
            Criteria criteria = example.createCriteria();
            criteria.andGoodsIdEqualTo(goodsId);// SPU ID
            criteria.andStatusEqualTo("1");// 状态有效
            example.setOrderByClause("is_default desc");// 按是否默认字段进行降序排序，目的是返回的结果第一条为默认SKU

            List<TbItem> itemList = itemMapper.selectByExample(example);
            dataModel.put("itemList", itemList);

            Writer out = new FileWriter(pagedir + goodsId + ".html");
            // 输出
            template.process(dataModel, out);
            out.close();
            return true;

        } catch (Exception e) {
            logger.info(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteItemHtml(Long[] goodsIds) {
        try {
            for (Long goodsId : goodsIds) {
                new File(pagedir + goodsId + ".html").delete();
            }
            return true;
        } catch (Exception e) {
            logger.info(e.getMessage());
            return false;
        }
    }

}
