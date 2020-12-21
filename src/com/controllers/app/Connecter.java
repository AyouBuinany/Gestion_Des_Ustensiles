package com.controllers.app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.config.app.ConnectionLoad;

public class Connecter {
	  public  Statement statement;
	  public PreparedStatement preparedStatement;
	  public ResultSet resultSet ;
	  ConnectionLoad connectLoad;
	  public Connection connect;
	  public Connecter() throws Exception {
		// TODO Auto-generated constructor stub
		  connectLoad= new ConnectionLoad("jdbc:mysql://localhost/Ustensile","root","");
		  statement=null;
		  preparedStatement=null;
		  resultSet=null;
		  this.connect=connectLoad.connectLoad();
	}

}
