package com.atguigu.service;

import com.atguigu.entity.Hospital;
import com.atguigu.mapper.HospitalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
public class HospitalService {

    //调用mapper
    @Autowired
    private HospitalMapper hospitalMapper;

    //列表
    public List<Hospital> getListService() {
        //调用mapper的方法
        List<Hospital> list = hospitalMapper.selectList(null);
        return list;
    }

    //医院添加
    public boolean saveHospService(Hospital hospital) {
        //调用mapper的方法
        hospitalMapper.insert(hospital);
        return true;
    }

    //医院删除功能
    public void deleteHospService(String id) {
        //调用mapper的方法
        hospitalMapper.deleteById(id);
    }

    //id查询
    public Hospital selectHospIdService(String id) {
        //调用mapper的方法
        Hospital hospital = hospitalMapper.selectById(id);
        return hospital;
    }

    //id修改
    public void updateHospitalService(Hospital hospital) {
        //调用mapper的方法
        hospitalMapper.updateById(hospital);
    }
}
