package com.controllers.app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.model.app.AssietteCarree;


public class ControllerAssietteCarree extends Connecter {
	  AssietteCarree asc;
	public ControllerAssietteCarree() throws Exception {
		// TODO Auto-generated constructor stub
		super();
		asc= new AssietteCarree();
	}
	//Add and update
		public int AddUpdateAssietteCarree( int id ,String annee,double cote,String choix) throws SQLException {
			String req="";
			
			if(choix=="Add") {
			req="INSERT INTO assiettecarree(cote,annee) VALUES(?,?)";
			preparedStatement=connect.prepareStatement(req);
			preparedStatement.setDouble(1, cote);
			preparedStatement.setString(2, annee);
			
			}else if(choix=="update"){
				req="UPDATE assiettecarree SET annee=? WHERE id =?";
				preparedStatement=connect.prepareStatement(req);
				preparedStatement.setString(1, annee);
				preparedStatement.setInt(2, id);
			}
			int executeReq=preparedStatement.executeUpdate();
			return executeReq;
		}
		//Afficher list
		public void AfficherAssietteCarree() throws Exception {
			String sql="SELECT * FROM AssietteCarree";
			statement=connect.createStatement(resultSet.TYPE_SCROLL_INSENSITIVE,resultSet.CONCUR_READ_ONLY);
			resultSet=statement.executeQuery(sql);
			while(resultSet.next()) {
				asc.setId(resultSet.getInt("id"));
				asc.setCote(resultSet.getDouble("cote"));
				asc.setYear(resultSet.getString("annee"));
				System.out.println(asc.toString());
			}
		}
		//Number rows
		public int NumberRowAssietteCarree() throws Exception {
			String sql="SELECT COUNT(id) FROM AssietteCarree";
			statement=connect.createStatement(resultSet.TYPE_SCROLL_INSENSITIVE,resultSet.CONCUR_READ_ONLY);
			resultSet=statement.executeQuery(sql);
			resultSet.next();
			return resultSet.getInt(1);
		}
}
