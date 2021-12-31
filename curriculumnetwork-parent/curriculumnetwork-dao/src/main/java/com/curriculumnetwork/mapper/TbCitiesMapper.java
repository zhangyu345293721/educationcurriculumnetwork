package com.curriculumnetwork.mapper;

import com.curriculumnetwork.pojo.TbCities;
import com.curriculumnetwork.pojo.TbCitiesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
/**
 * @author zhangyu
 *  mapper
 */
public interface TbCitiesMapper {
    int countByExample(TbCitiesExample example);

    int deleteByExample(TbCitiesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbCities record);

    int insertSelective(TbCities record);

    List<TbCities> selectByExample(TbCitiesExample example);

    TbCities selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbCities record, @Param("example") TbCitiesExample example);

    int updateByExample(@Param("record") TbCities record, @Param("example") TbCitiesExample example);

    int updateByPrimaryKeySelective(TbCities record);

    int updateByPrimaryKey(TbCities record);
}