package com.controllers.app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.config.app.ConnectionLoad;
import com.model.app.Cuillere;

public class ControllerCuillere extends Connecter {
	Cuillere cuiller;
	  public ControllerCuillere() throws Exception {
		// TODO Auto-generated constructor stub
		 super();
		  cuiller= new Cuillere();
		
	  }
	  
	  
	//Add and update
		public int AddUpdateCuillere( int id ,String annee,double longueur,String choix) throws SQLException {
			String req="";
			
			if(choix=="Add") {
			req="INSERT INTO Cuillere(longueur,annee) VALUES(?,?)";
			preparedStatement=connect.prepareStatement(req);
			preparedStatement.setDouble(1, longueur);
			preparedStatement.setString(2, annee);
			
			}else if(choix=="update"){
				req="UPDATE Cuillere SET annee=? WHERE id =?";
				preparedStatement=connect.prepareStatement(req);
				preparedStatement.setString(1, annee);
				preparedStatement.setInt(2, id);
			}
			int executeReq=preparedStatement.executeUpdate();
			return executeReq;
		}
		
		//Afficher
	  public void AfficherCuillere()  throws Exception {
		 
			statement=connect.createStatement(resultSet.TYPE_SCROLL_INSENSITIVE,resultSet.CONCUR_READ_ONLY);
			String req= "SELECT * FROM cuillere";
			resultSet=statement.executeQuery(req);
			while(resultSet.next()) {
				cuiller.setId(resultSet.getInt("id"));
				cuiller.setLongeur(resultSet.getDouble("longueur"));
				cuiller.setYear(resultSet.getString("annee"));
				System.out.println(cuiller.toString());
			}
	  }

	//Number rows
			public int NumberRowCuillere() throws Exception {
				String sql="SELECT COUNT(*) FROM cuillere";
				statement=connect.createStatement(resultSet.TYPE_SCROLL_INSENSITIVE,resultSet.CONCUR_READ_ONLY);
				resultSet=statement.executeQuery(sql);
				resultSet.next();
				return resultSet.getInt(1);
			}
}
