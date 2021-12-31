package com.curriculumnetwork.mapper;

import com.curriculumnetwork.pojo.TbSeller;
import com.curriculumnetwork.pojo.TbSellerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @author zhangyu
 *  mapper
 */
public interface TbSellerMapper {
    int countByExample(TbSellerExample example);

    int deleteByExample(TbSellerExample example);

    int deleteByPrimaryKey(String sellerId);

    int insert(TbSeller record);

    int insertSelective(TbSeller record);

    List<TbSeller> selectByExample(TbSellerExample example);

    TbSeller selectByPrimaryKey(String sellerId);

    int updateByExampleSelective(@Param("record") TbSeller record, @Param("example") TbSellerExample example);

    int updateByExample(@Param("record") TbSeller record, @Param("example") TbSellerExample example);

    int updateByPrimaryKeySelective(TbSeller record);

    int updateByPrimaryKey(TbSeller record);
}