package com.icis.service.impl;

import com.icis.mapper.ProvinceMapper;
import com.icis.pojo.Province;
import com.icis.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProvinceServiceImpl implements ProvinceService {

    @Autowired
    private ProvinceMapper provinceMapper;

    @Override
    public List<Province> listProvince() {
        return provinceMapper.listProvince();
    }
}
