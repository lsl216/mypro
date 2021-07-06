package com.icis.controller;

import com.icis.pojo.Province;
import com.icis.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class ProvinceController {
    @Autowired
    private ProvinceService provinceService;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @RequestMapping(value = "/getProvince",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Map<Object, Object> getProvince(){
        Map<Object, Object> province = redisTemplate.boundHashOps("province").entries();
        if(province.size()==0){
            List<Province> provinces = provinceService.listProvince();
            for (Province p : provinces) {
                province.put(p.getId(),p.getProvinceName());
                redisTemplate.boundHashOps("province").put(String.valueOf(p.getId()),p.getProvinceName());
            }
        }
        return province;
    }
}
