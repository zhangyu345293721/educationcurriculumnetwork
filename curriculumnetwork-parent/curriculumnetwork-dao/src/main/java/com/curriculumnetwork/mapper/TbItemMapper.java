package com.curriculumnetwork.mapper;

import com.curriculumnetwork.pojo.TbItem;
import com.curriculumnetwork.pojo.TbItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @author zhangyu
 *  mapper
 */
public interface TbItemMapper {
    int countByExample(TbItemExample example);

    int deleteByExample(TbItemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbItem record);

    int insertSelective(TbItem record);

    List<TbItem> selectByExample(TbItemExample example);

    TbItem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbItem record, @Param("example") TbItemExample example);

    int updateByExample(@Param("record") TbItem record, @Param("example") TbItemExample example);

    int updateByPrimaryKeySelective(TbItem record);

    int updateByPrimaryKey(TbItem record);
}