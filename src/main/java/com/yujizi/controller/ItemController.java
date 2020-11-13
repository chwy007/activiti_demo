package com.yujizi.controller;

import com.yujizi.pojo.Item;
import com.yujizi.pojo.ItemQuery;
import com.yujizi.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * @ProjectName: activiti_demo
 * @Package: com.yujizi.controller
 * @ClassName: ItemController
 * @Author: ychw
 * @Description:
 * @Date: 2020/11/13 10:52
 * @Version: 1.0
 */
@Controller
@RequestMapping("item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @RequestMapping("countByExample")
    @ResponseBody
    public long countByExample(ItemQuery example) {
        return itemService.countByExample(example);
    }

    @RequestMapping("deleteByExample")
    @ResponseBody
    public int deleteByExample(ItemQuery example) {
        return itemService.deleteByExample(example);
    }

    @RequestMapping("delete/{id}")
    @ResponseBody
    public int deleteByPrimaryKey(@PathVariable Integer id) {
        return itemService.deleteByPrimaryKey(id);
    }


    @RequestMapping("insert")
    @ResponseBody
    public int insert(Item record) {
        return itemService.insert(record);
    }

    @RequestMapping("insertSelective")
    @ResponseBody
    public int insertSelective(Item record) {
        return itemService.insertSelective(record);
    }

    @RequestMapping("selectByExample")
    @ResponseBody
    public List<Item> selectByExample(ItemQuery example) {
        return itemService.selectByExample(example);
    }

    @RequestMapping("select/{id}")
    @ResponseBody
    public Item selectByPrimaryKey(@PathVariable Integer id) {
        return itemService.selectByPrimaryKey(id);
    }

    @RequestMapping("updateByExampleSelective")
    @ResponseBody
    public int updateByExampleSelective(Item record) {
        return itemService.updateByExampleSelective(record);
    }

    @RequestMapping("updateByExample")
    @ResponseBody
    public int updateByExample(Item record) {
        return itemService.updateByExample(record);
    }

    @RequestMapping("updateByPrimaryKeySelective")
    @ResponseBody
    public int updateByPrimaryKeySelective(Item record) {
        return itemService.updateByPrimaryKeySelective(record);
    }

    @RequestMapping("updateByPrimaryKey")
    @ResponseBody
    public int updateByPrimaryKey(Item record) {
        return itemService.updateByPrimaryKey(record);
    }

}
