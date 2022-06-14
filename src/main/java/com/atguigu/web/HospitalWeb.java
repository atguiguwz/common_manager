package com.atguigu.web;

import com.atguigu.entity.Hospital;
import com.atguigu.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/hospital")
@CrossOrigin  //允许不同端口号进行访问
public class HospitalWeb {

    //调用service
    @Autowired
    private HospitalService hospitalService;

    //最终修改
    @GetMapping("/update")
    public boolean updateHosp(Hospital hospital) {
        //调用service方法
        hospitalService.updateHospitalService(hospital);
        return true;
    }

    //id查询
    @GetMapping("/getHosp/{id}")
    public Hospital getHospital(@PathVariable String id) {
        //调用service方法id查询
        Hospital hospital = hospitalService.selectHospIdService(id);
        return hospital;
    }

    //医院删除功能
    @GetMapping("/delete/{id}")   //占位符方式
    public boolean deleteHospital(@PathVariable String id) {
        //调用service方法删除
        hospitalService.deleteHospService(id);
        return true;
    }

    //医院添加功能
    @GetMapping("/add")
    public boolean addHospital(Hospital hospital) {
        //1 获取表单提交数据，使用对象方式获取，hospital类属性表单name值相同
        //2 调用service方法实现添加
        boolean isSuccess = hospitalService.saveHospService(hospital);
        return isSuccess;
    }

    // http://localhost:8080/hospital/list
    //医院列表功能   /list固定，为了后面前端可以整合
    @GetMapping("/list")
    public List getHospitalList() {
        //调用service层的方法
        //  alt  enter 创建方法
        List<Hospital> list = hospitalService.getListService();
        //返回list集合
        return list;
    }

}
