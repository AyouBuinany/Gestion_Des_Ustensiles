package com.controllers.app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.config.app.ConnectionLoad;
import com.model.app.AssietteRonde;

public class ControllerAssietteRonde extends Connecter {
	  AssietteRonde asr;
	public ControllerAssietteRonde() throws Exception {
		super();
		asr= new AssietteRonde();
	}
	//Add and update
	

	public int AddUpdateAssietteRounde( int id ,String annee,double rayon,String choix) throws SQLException {
		String req="";
		
		if(choix=="Add") {
		req="INSERT INTO assietteronde(rayon,annee) VALUES(?,?)";
		preparedStatement=connect.prepareStatement(req);
		preparedStatement.setDouble(1, rayon);
		preparedStatement.setString(2, annee);
		
		}else if(choix=="update"){
			req="UPDATE assietteronde SET annee=? WHERE id =?";
			preparedStatement=connect.prepareStatement(req);
			preparedStatement.setString(1, annee);
			preparedStatement.setInt(2, id);
		}
		int executeReq=preparedStatement.executeUpdate();
		return executeReq;
	}
	//Afficher list
	public void AfficherAssietteRounde() throws Exception {
		String sql="SELECT * FROM assietteronde";
		statement=connect.createStatement(resultSet.TYPE_SCROLL_INSENSITIVE,resultSet.CONCUR_READ_ONLY);
		resultSet=statement.executeQuery(sql);
		while(resultSet.next()) {
			asr.setId(resultSet.getInt("id"));
			asr.setRayon(resultSet.getDouble("rayon"));
			asr.setYear(resultSet.getString("annee"));
			System.out.println(asr.toString());
		}
		statement.close();
	}
	//Number rows
	public int NumberRowAssietteRounde() throws Exception {
		int count=0;
		String sql="SELECT COUNT(*) FROM assietteronde";
		statement=connect.createStatement(resultSet.TYPE_SCROLL_INSENSITIVE,resultSet.CONCUR_READ_ONLY);
		resultSet=statement.executeQuery(sql);
		resultSet.next();
		count = resultSet.getInt(1);
		return count;
		
	}

}
