package com.example.demo2.controller;

import java.util.List;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Echarts;
import com.example.demo.model.SysNews;
import com.example.demo.service.EchartsService;
import com.example.demo.service.SysNewService;

@RestController
@RequestMapping("/api")
@CrossOrigin // 跨域连接
public class MessageController {

	@Autowired
	private SysNewService sysNewService;
	@Autowired
	private EchartsService echartsService;

//	@PostMapping("/login")
//	public ModelMap login(SysNews user) {
//		ModelMap map = new ModelMap();
//		String name = user.getUsername();
//		String pass = user.getPassword();
//		this.sysNewService.checkLogin(name, pass);
//		return map;
//	}
	@GetMapping("/login")
	public ModelMap login(@RequestParam(value = "name") String name,@RequestParam(value = "pass") String pass) {
		ModelMap map = new ModelMap();
		SysNews userInfo = sysNewService.checkLogin(name, pass);
		if (userInfo!=null) {
			map.put("userInfo", userInfo);
			map.put("code", "200");
			map.put("message", "登录成功");
			return map;		
		}
		map.put("code", "404");
		map.put("message", "登录失败33");
		return map;
	}

	@GetMapping("/select")
	public ModelMap select() {
		ModelMap map = new ModelMap();
		List<Echarts> list = echartsService.select();
		map.addAttribute("list", list);
		return map;
	}

}
