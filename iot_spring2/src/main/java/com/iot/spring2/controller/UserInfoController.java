package com.iot.spring2.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iot.spring2.service.UserInfoService;
import com.iot.spring2.vo.UserInfoVO;

@Controller
@RequestMapping("/user")
public class UserInfoController {	
	private static final Logger log = LoggerFactory.getLogger(UserInfoController.class);
	
	@Autowired
	private UserInfoService uis;
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> login(UserInfoVO ui, HttpSession hs){
		Map<String,Object> map = new HashMap<String,Object>();
		if(uis.login(map, ui)) {
			hs.setAttribute("user", map.get("user"));
		}		
		return map;
		
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> join(@RequestBody UserInfoVO ui){		
		Map<String,Object> map = new HashMap<String,Object>();
		log.info("insertUI=>{}",ui);
		
		if(uis.join(map,ui)) {
			map.put("msg", "회원가입에 성공하셨습니다");
			map.put("biz", true);
		}
		
		return map;
		
	}
	
	@RequestMapping(value="/join2", method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> join(@RequestParam Map<String,Object> um){		
		log.info("insertUM=>{}",um);
		return um;		
	}

}
