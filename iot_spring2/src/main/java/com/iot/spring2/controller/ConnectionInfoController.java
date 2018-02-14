package com.iot.spring2.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iot.spring2.service.ConnectionInfoService;
import com.iot.spring2.vo.ConnectionInfoVO;
import com.iot.spring2.vo.UserInfoVO;

@Controller
@RequestMapping("/connection")
public class ConnectionInfoController {
	@Autowired
	private ConnectionInfoService cis;
		
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> getConnectionList(HttpSession hs, Map<String, Object> map){
		UserInfoVO ui = new UserInfoVO();
		if(hs.getAttribute("user")!=null) {
			ui = (UserInfoVO) hs.getAttribute("user");			
		}else {
			ui.setUiID("red");
		}		
		ConnectionInfoVO ci = new ConnectionInfoVO();
		ci.setUiID(ui.getUiID());
		
		map.put("list", cis.getConnectionInfoList(ci));		
		return map;
	}
	
	@RequestMapping(value="/db_list/{parentId}", method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> getDatabaseList(
			@PathVariable("parentId") int parentId,
			Map<String,Object> map,	HttpSession hs){
		
		
		
	
		map.put("parentId", parentId);
		
		return map;
	}
	

}
