package com.example.demo1.dao;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.SysNews;


@Mapper
public interface SysNewsMapper {
	SysNews checkLogin(String name, String pass);
}
