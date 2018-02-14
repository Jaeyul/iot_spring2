package com.iot.spring2.service.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iot.spring2.dao.ConnectionInfoDAO;
import com.iot.spring2.service.ConnectionInfoService;
import com.iot.spring2.vo.ConnectionInfoVO;

@Service
public class ConnectionInfoServiceImpl implements ConnectionInfoService {
	@Autowired
	private ConnectionInfoDAO cidao;

	@Override
	public List<ConnectionInfoVO> getConnectionInfoList(ConnectionInfoVO ci) {
		
		return cidao.selectConnectionInfoList(ci);
	}

	@Override
	public List<Map<String, Object>> getDatabaseList(ConnectionInfoVO ci, HttpSession hs) {
		
		
		
		return null;
	}

}
