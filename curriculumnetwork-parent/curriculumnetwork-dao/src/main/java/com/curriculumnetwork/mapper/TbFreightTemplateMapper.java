package com.curriculumnetwork.mapper;

import com.curriculumnetwork.pojo.TbFreightTemplate;
import com.curriculumnetwork.pojo.TbFreightTemplateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @author zhangyu
 *  mapper
 */
public interface TbFreightTemplateMapper {
    int countByExample(TbFreightTemplateExample example);

    int deleteByExample(TbFreightTemplateExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbFreightTemplate record);

    int insertSelective(TbFreightTemplate record);

    List<TbFreightTemplate> selectByExample(TbFreightTemplateExample example);

    TbFreightTemplate selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbFreightTemplate record, @Param("example") TbFreightTemplateExample example);

    int updateByExample(@Param("record") TbFreightTemplate record, @Param("example") TbFreightTemplateExample example);

    int updateByPrimaryKeySelective(TbFreightTemplate record);

    int updateByPrimaryKey(TbFreightTemplate record);
}