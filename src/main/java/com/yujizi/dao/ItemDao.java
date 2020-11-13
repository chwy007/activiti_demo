package com.yujizi.dao;


import com.yujizi.pojo.Item;
import com.yujizi.pojo.ItemQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ItemDao {
    long countByExample(ItemQuery example);

    int deleteByExample(ItemQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(Item record);

    int insertSelective(Item record);

    List<Item> selectByExample(ItemQuery example);

    Item selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Item record, @Param("example") ItemQuery example);

    int updateByExample(@Param("record") Item record, @Param("example") ItemQuery example);

    int updateByPrimaryKeySelective(Item record);

    int updateByPrimaryKey(Item record);
}