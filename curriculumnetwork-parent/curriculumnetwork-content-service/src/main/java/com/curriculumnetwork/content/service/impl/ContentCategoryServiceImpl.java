package com.curriculumnetwork.content.service.impl;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.curriculumnetwork.content.service.ContentCategoryService;
import com.curriculumnetwork.mapper.TbContentCategoryMapper;
import com.curriculumnetwork.pojo.TbContentCategory;
import com.curriculumnetwork.pojo.TbContentCategoryExample;
import com.curriculumnetwork.pojo.TbContentCategoryExample.Criteria;

import entity.PageResult;

/**
 * 服务实现层
 *
 * @author:zhangyu
 */
@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {
    private static Logger logger = LoggerFactory.getLogger(ContentCategoryServiceImpl.class);
    @Autowired
    private TbContentCategoryMapper contentCategoryMapper;


    /**
     * 查询全部
     *
     * @return 全部结果链表
     */
    @Override
    public List<TbContentCategory> findAll() {
        return contentCategoryMapper.selectByExample(null);
    }

    /**
     * 按分页查询
     *
     * @param pageNum  页数目
     * @param pageSize 页面大小
     * @return 页面结果
     */
    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<TbContentCategory> page = (Page<TbContentCategory>) contentCategoryMapper.selectByExample(null);
        return new PageResult(page.getTotal(), page.getResult());
    }


    /**
     * 增加目录类
     *
     * @param contentCategory 增加目录类别
     */
    @Override
    public void add(TbContentCategory contentCategory) {
        contentCategoryMapper.insert(contentCategory);
    }


    /**
     * 更新目录类别
     *
     * @param contentCategory 目录类别
     */
    @Override
    public void update(TbContentCategory contentCategory) {
        contentCategoryMapper.updateByPrimaryKey(contentCategory);
    }

    /**
     * 根据ID获取实体
     *
     * @param id 统一标识
     * @return 商品实体
     */
    @Override
    public TbContentCategory findOne(Long id) {
        return contentCategoryMapper.selectByPrimaryKey(id);
    }

    /**
     * 批量删除
     *
     * @param ids 商品id数组
     */
    @Override
    public void delete(Long[] ids) {
        for (Long id : ids) {
            contentCategoryMapper.deleteByPrimaryKey(id);
        }
    }


    /**
     * @param contentCategory 内容类别
     * @param pageNum         当前页 码
     * @param pageSize        每页记录数
     * @return
     */
    @Override
    public PageResult findPage(TbContentCategory contentCategory, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        TbContentCategoryExample example = new TbContentCategoryExample();
        Criteria criteria = example.createCriteria();

        if (contentCategory != null) {
            if (contentCategory.getName() != null && contentCategory.getName().length() > 0) {
                criteria.andNameLike("%" + contentCategory.getName() + "%");
            }
        }
        Page<TbContentCategory> page = (Page<TbContentCategory>) contentCategoryMapper.selectByExample(example);
        return new PageResult(page.getTotal(), page.getResult());
    }
}
