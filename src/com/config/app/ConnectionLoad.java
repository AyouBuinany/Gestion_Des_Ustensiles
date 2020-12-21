package com.config.app;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class ConnectionLoad {
private Connection connect;
private String host;
private String UserName;
private String Password;
	public ConnectionLoad(String host, String UserName,String Password)
	{
	this.host= host;
	this.UserName= UserName;
	this.Password=Password;
	}
	public Connection getConnect() {
		return connect;
	}
	public void setConnect(Connection connect) {
		this.connect = connect;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	//Connection Load
	public Connection connectLoad() throws Exception {
		connect= (Connection) DriverManager.getConnection(getHost(), getUserName(), getPassword());
		return connect;
	}
}
