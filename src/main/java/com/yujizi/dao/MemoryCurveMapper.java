package com.yujizi.dao;

import com.yujizi.pojo.MemoryCurve;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ProjectName: activiti_demo
 * @Package: com.yujizi.dao
 * @ClassName: MemoryCurveMapper
 * @Author: ychw
 * @Description:
 * @Date: 2020/11/6 10:05
 * @Version: 1.0
 */
public interface MemoryCurveMapper {
    MemoryCurve findByID(Integer id);

    List<MemoryCurve> findAll();

    void insert(@Param("memoryCurve") MemoryCurve memoryCurve);

    void deleteByID(Integer id);
}
