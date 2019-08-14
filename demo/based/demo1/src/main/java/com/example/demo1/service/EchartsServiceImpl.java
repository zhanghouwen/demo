package com.example.demo1.service;



import com.example.demo.model.Echarts;
import com.example.demo.service.EchartsService;
import com.example.demo1.dao.EchartsMapper;

import java.util.List;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class EchartsServiceImpl implements EchartsService
{

  @Autowired
  private EchartsMapper echartsMapper;
   
    @Override
    public List<Echarts> select() {

        return echartsMapper.select();
    }
}
