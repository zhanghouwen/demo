package com.example.demo1.service;

import com.example.demo.model.SysNews;
import com.example.demo.service.SysNewService;
import com.example.demo1.dao.SysNewsMapper;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class SysNewServiceImpl implements SysNewService {

	@Autowired
	private SysNewsMapper sysNewsMapper;

	@Override
	public SysNews checkLogin(String name, String pass) {

		return sysNewsMapper.checkLogin(name, pass);
	}
}
