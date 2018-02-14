package com.iot.spring2.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iot.spring2.dao.UserInfoDAO;
import com.iot.spring2.service.UserInfoService;
import com.iot.spring2.vo.UserInfoVO;


@Service
public class UserInfoServiceImpl implements UserInfoService {
	@Autowired
	private UserInfoDAO uidao;

	@Override
	public boolean login(Map<String, Object> rMap, UserInfoVO ui) {		
		ui = uidao.selectUserInfo(ui);
		rMap.put("msg", "아이디 비밀번호를 확인해주세요.");
		rMap.put("biz", false);			
		if(ui!=null) {
			rMap.put("msg", ui.getUiName() + "님 로그인에 성공하셧습니다.");
			rMap.put("biz", true);	
			rMap.put("user", ui);
			return true;
		}		
		return false;
	}

	@Override
	public boolean join(Map<String, Object> rMap, UserInfoVO ui) {
		String pwd = ui.getUiPwd();
		ui.setUiPwd(null);				
		if(uidao.selectUserInfo(ui)!=null) {
			rMap.put("msg", "중복된 아이디가 있습니다.");
			rMap.put("biz", false);
			return false;			
		}
		ui.setUiPwd(pwd);
		if(uidao.insertUserInfo(ui)!=1) {
			rMap.put("msg", "회원가입에 실패하셨습니다.");
			rMap.put("biz", false);
			return false;
		}
		return true;
	}

}
