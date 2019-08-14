package com.example.demo1.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.Echarts;


@Mapper
public interface EchartsMapper {

	List<Echarts> select();
}
