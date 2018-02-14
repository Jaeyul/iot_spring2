package com.iot.spring2.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iot.spring2.dao.ConnectionInfoDAO;
import com.iot.spring2.vo.ConnectionInfoVO;

@Repository
public class ConnectionInfoDAOImpl implements ConnectionInfoDAO{
	
	@Autowired
	private SqlSessionFactory ssf;

	@Override
	public List<ConnectionInfoVO> selectConnectionInfoList(ConnectionInfoVO ci) {
		
		SqlSession ss = ssf.openSession();
		List<ConnectionInfoVO> connectionInfoList = ss.selectList("connection_info.selectConnectionInfo", ci);
		ss.close();
		return connectionInfoList;
	}

	@Override
	public List<Map<String, Object>> selectDatabaseList(SqlSession ss) {
		
		
		return null;
	}
	
	

	
	

}
