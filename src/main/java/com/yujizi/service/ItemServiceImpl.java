package com.yujizi.service;

import com.yujizi.dao.ItemDao;
import com.yujizi.pojo.Item;
import com.yujizi.pojo.ItemQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @ProjectName: activiti_demo
 * @Package: com.yujizi.service
 * @ClassName: ItemServiceImpl
 * @Author: ychw
 * @Description:
 * @Date: 2020/11/13 10:52
 * @Version: 1.0
 */
@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    private ItemDao itemDao;


    @Override
    public long countByExample(ItemQuery example) {
        return itemDao.countByExample(example);
    }

    @Override
    public int deleteByExample(ItemQuery example) {
        return itemDao.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return itemDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Item record) {
        record.setCreatedTime(new Date());
        return itemDao.insert(record);
    }

    @Override
    public int insertSelective(Item record) {
        return itemDao.insertSelective(record);
    }

    @Override
    public List<Item> selectByExample(ItemQuery example) {
        return itemDao.selectByExample(example);
    }

    @Override
    public Item selectByPrimaryKey(Integer id) {
        return itemDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(Item record) {
        ItemQuery example = new ItemQuery();
        ItemQuery.Criteria criteria1 = example.createCriteria();
        criteria1.andIdEqualTo(record.getId());
        return itemDao.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(Item record) {
        ItemQuery example = new ItemQuery();
        ItemQuery.Criteria criteria1 = example.createCriteria();
        criteria1.andIdEqualTo(record.getId());
        return itemDao.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(Item record) {
        return itemDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Item record) {
        return itemDao.updateByPrimaryKey(record);
    }
}
