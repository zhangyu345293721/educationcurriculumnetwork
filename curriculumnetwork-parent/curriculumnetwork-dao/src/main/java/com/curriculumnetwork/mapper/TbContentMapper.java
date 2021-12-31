package com.curriculumnetwork.mapper;

import com.curriculumnetwork.pojo.TbContent;
import com.curriculumnetwork.pojo.TbContentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
/**
 * @author zhangyu
 *  mapper
 */
public interface TbContentMapper {
    int countByExample(TbContentExample example);

    int deleteByExample(TbContentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbContent record);

    int insertSelective(TbContent record);

    List<TbContent> selectByExample(TbContentExample example);

    TbContent selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbContent record, @Param("example") TbContentExample example);

    int updateByExample(@Param("record") TbContent record, @Param("example") TbContentExample example);

    int updateByPrimaryKeySelective(TbContent record);

    int updateByPrimaryKey(TbContent record);
}