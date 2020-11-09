package com.yujizi.service;

import com.yujizi.dao.MemoryCurveMapper;
import com.yujizi.pojo.MemoryCurve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

/**
 * @ProjectName: activiti_demo
 * @Package: com.yujizi.service
 * @ClassName: MemoryCurveServiceImpl
 * @Author: ychw
 * @Description:
 * @Date: 2020/11/6 13:33
 * @Version: 1.0
 */
@Service
public class MemoryCurveServiceImpl implements MemoryCurveService{
    @Autowired
    private MemoryCurveMapper memoryCurveMapper;


    @Override
    public MemoryCurve findByID(Integer id) {
        return memoryCurveMapper.findByID(id);
    }

    @Override
    public List<MemoryCurve> findAll() {
        return memoryCurveMapper.findAll();
    }

    @Override
    public void insert(String course) {
        MemoryCurve memoryCurve1 = new MemoryCurve();
        memoryCurve1.setCourse(course);
        Calendar instance = Calendar.getInstance();
        memoryCurve1.setCreatedTime(instance.getTime());
        instance.add(Calendar.MINUTE,5);
        memoryCurve1.setFiveMmLater(instance.getTime());
        instance.add(Calendar.MINUTE,15);
        memoryCurve1.setTwentyMmLater(instance.getTime());
        instance.add(Calendar.MINUTE,40);
        memoryCurve1.setOneHhLater(instance.getTime());
        instance.add(Calendar.MINUTE,60*8);
        memoryCurve1.setNineHhLater(instance.getTime());
        instance.add(Calendar.MINUTE,60*15);
        memoryCurve1.setOneDayLater(instance.getTime());
        instance.add(Calendar.MINUTE,60*24);
        memoryCurve1.setTwoDayLater(instance.getTime());
        instance.add(Calendar.MINUTE,60*24*3);
        memoryCurve1.setFiveDayLater(instance.getTime());
        instance.add(Calendar.MINUTE,60*24*3);
        memoryCurve1.setEightDayLater(instance.getTime());
        instance.add(Calendar.MINUTE,60*24*6);
        memoryCurve1.setFourteenDayLater(instance.getTime());
        memoryCurveMapper.insert(memoryCurve1);
    }

    @Override
    public void deleteByID(Integer id) {
        memoryCurveMapper.deleteByID(id);
    }


}
