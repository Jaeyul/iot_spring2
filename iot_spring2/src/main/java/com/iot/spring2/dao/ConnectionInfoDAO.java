package com.iot.spring2.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.iot.spring2.vo.ConnectionInfoVO;

public interface ConnectionInfoDAO {
	
	public List<ConnectionInfoVO> selectConnectionInfoList(ConnectionInfoVO ci);
	public List<Map<String,Object>> selectDatabaseList(SqlSession ss);

}
