package com.iot.spring2.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.iot.spring2.vo.ConnectionInfoVO;

public interface ConnectionInfoService {
	
	public List<ConnectionInfoVO> getConnectionInfoList(ConnectionInfoVO ci);	
	public List<Map<String, Object>> getDatabaseList(ConnectionInfoVO ci, HttpSession hs);

}
