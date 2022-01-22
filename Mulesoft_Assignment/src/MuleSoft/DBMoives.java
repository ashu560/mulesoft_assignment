package MuleSoft;

import java.sql.*;

public class DBMoives {
	void Retrive() {
		   try {
			   Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mulesoft_assignment", "root", "root");
			   System.out.println("Connected With the database successfully");
			           PreparedStatement preparedStatement=connection.prepareStatement("select * from movie");
			           ResultSet resultSet=preparedStatement.executeQuery();
			           if(resultSet.next()== false)
			           {
			        	   System.out.println("No Record Found");
			           }else {
			        	   do{
				                String movieName=resultSet.getString("name");
				                String actorName=resultSet.getString("actor");
				                String releasedate=resultSet.getString("releasedate");
				                String directorName=resultSet.getString("director");
				                System.out.println(movieName+" "+actorName+" "+directorName+" "+releasedate+"\n");
				           }while(resultSet.next());
			           }
			           
			   } catch (SQLException e) {
				   	    System.out.println("Error while connecting to the database");
			   }
	}
	
	void Insert(String movieName,String actorName,String directorName,String releaseDate)
	{
		  try {
			  			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mulesoft_assignment", "root", "root");
			  			System.out.println("Connected With the database successfully");
			  			PreparedStatement preparedStatement=connection.prepareStatement("insert into movie values(?,?,?,?)");
			  			preparedStatement.setString(1,movieName);
			  			preparedStatement.setString(2,actorName);
			  			preparedStatement.setNString(3, releaseDate);
			  			preparedStatement.setNString(4, directorName);
			            preparedStatement.executeUpdate();
			            System.out.println("data inserted successfully");
			  } catch (SQLException e) {
				  		System.out.println("Error while connecting to the database");
			  }
	}
	void delete(String movieName) {
		  try {
			  		  Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mulesoft_assignment", "root", "root");
			  		  System.out.println("Connected With the database successfully");
			          PreparedStatement preparedStatement=connection.prepareStatement("delete from movie where name=?");
			          preparedStatement.setString(1,movieName);
			          preparedStatement.executeUpdate();
			          System.out.println("Data deleted Successfully");
			  } catch (SQLException e) {
				  	  System.out.println("Error while connecting to the database");
			  }
	}
	  void update(String movieName,String actorName,String directorName,String releaseDate)
	  {
		  try {
				Connection	 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mulesoft_assignment", "root", "root");
				System.out.println("Connected With the database successfully");
		        PreparedStatement preparedStatement=connection.prepareStatement("update movie set actor=?,director=?,releasedate=? where name=?");
		        preparedStatement.setString(1,actorName);
		        preparedStatement.setString(2,directorName);
		        preparedStatement.setString(3,releaseDate);
		        preparedStatement.setString(4,movieName);
		        preparedStatement.executeUpdate();
		        System.out.println("data updated successfully");
				
				
			} catch (SQLException e) {
				
				System.out.println("Error while connecting to the database");
			
					}
	  }
}
