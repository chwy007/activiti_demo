package com.yujizi.controller;

import com.yujizi.pojo.MemoryCurve;
import com.yujizi.service.MemoryCurveService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ProjectName: activiti_demo
 * @Package: com.yujizi.controller
 * @ClassName: MemoryCurveController
 * @Author: ychw
 * @Description:
 * @Date: 2020/11/6 13:32
 * @Version: 1.0
 */
@Controller

@RequestMapping("memoryCurve")
public class MemoryCurveController {
    @Autowired
    private MemoryCurveService memoryCurveService;


    @RequiresRoles("staff")
    @RequestMapping("find/{id}")
    @ResponseBody
    public MemoryCurve findByID(@PathVariable Integer id) {
        return memoryCurveService.findByID(id);

    }

    @RequiresPermissions("second-level")
    @RequestMapping("all")
    @ResponseBody
    public List<MemoryCurve> findAll() {
        return memoryCurveService.findAll();
    }

    @RequiresPermissions("first-level")
    @RequestMapping("insert")
    @ResponseBody
    public String insert(String course) {
        memoryCurveService.insert(course);
        return "success";
    }

    @RequiresPermissions("first-level")
    @RequestMapping("delete/{id}")
    @ResponseBody
    public String deleteByID(@PathVariable Integer id){
        memoryCurveService.deleteByID(id);
        return "success";
    }


}
