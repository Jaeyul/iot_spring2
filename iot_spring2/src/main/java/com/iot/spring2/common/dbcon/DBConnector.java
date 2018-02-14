package com.iot.spring2.common.dbcon;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.core.io.ClassPathResource;

import com.iot.spring2.vo.ConnectionInfoVO;

public class DBConnector {
	
	private BasicDataSource bds;
	private SqlSessionFactoryBean ssfb;
	
	public DBConnector(ConnectionInfoVO ci) {
		bds.setDriverClassName("org.mariadb.jdbc.Driver");
		String url = "jdbc:mysql://" + ci.getCiUrl() + ":" + ci.getCiPort() + "/" + ci.getCiDatabase();
		//jdbc:mysql://localhost:3306/dbconnector
		bds.setUrl(url);
		bds.setUsername(ci.getCiUser());
		bds.setPassword(ci.getCiPwd());
		ssfb = new SqlSessionFactoryBean();
		ssfb.setDataSource(bds);
		ssfb.setConfigLocation(new ClassPathResource("/mybatis-config.xml"));		
		
	}
	
	public SqlSession getSqlSession() throws Exception {
		
		return ssfb.getObject().openSession();
	}

}
