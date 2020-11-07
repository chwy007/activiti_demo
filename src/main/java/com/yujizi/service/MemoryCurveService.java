package com.yujizi.service;

import com.yujizi.pojo.MemoryCurve;

import java.util.List;

/**
 * @ProjectName: activiti_demo
 * @Package: com.yujizi.service
 * @ClassName: MemoryCurveService
 * @Author: ychw
 * @Description:
 * @Date: 2020/11/6 13:32
 * @Version: 1.0
 */
public interface MemoryCurveService {
    MemoryCurve findByID(Integer id);
    void insert(String course);
    List<MemoryCurve> findAll();
}
