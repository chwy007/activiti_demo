package com.yujizi.service;

import com.yujizi.pojo.Item;
import com.yujizi.pojo.ItemQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ProjectName: activiti_demo
 * @Package: com.yujizi.service
 * @ClassName: ItemService
 * @Author: ychw
 * @Description:
 * @Date: 2020/11/13 10:52
 * @Version: 1.0
 */
public interface ItemService {


    long countByExample(ItemQuery example);

    int deleteByExample(ItemQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(Item record);

    int insertSelective(Item record);

    List<Item> selectByExample(ItemQuery example);

    Item selectByPrimaryKey(Integer id);

    int updateByExampleSelective(Item record);

    int updateByExample(Item record);

    int updateByPrimaryKeySelective(Item record);

    int updateByPrimaryKey(Item record);

}
