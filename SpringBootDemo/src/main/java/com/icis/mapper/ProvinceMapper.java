package com.icis.mapper;

import com.icis.pojo.Province;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProvinceMapper {
    List<Province> listProvince();
}
