package com.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.dataBase.JdbcConnection;
import com.pojo.User;


@Controller
public class UpdateDataServices {
	@RequestMapping(method = RequestMethod.POST, value = "/update" )
	@ResponseBody
	public String getUpdate(String state, String confirmed,String recovered,String active, String death,String userName ,String token) throws SQLException 
	{   
		JdbcConnection dbc = new JdbcConnection();
		Connection connection = null;
		connection = dbc.getDBConnection();
		
		UpdateDataServices update=new UpdateDataServices();
		
		User validate= update.validateToken(userName, token);
//		User user=new User();
//		String value=user.getToken();
	
		if(!validate.equals(null))
		{
        String sqlUpdate = "UPDATE country_data.statedata SET confirmed=?, active=?, recovered=?,death = ?  WHERE state=?";
		    
        PreparedStatement statement = connection.prepareStatement(sqlUpdate);
        try  {
            
            statement.setString(1, confirmed);
            statement.setString(2, active);
            statement.setString(3, recovered);
            statement.setString(4, death);
            statement.setString(5, state);

            int rowAffected = statement.executeUpdate();
       
            System.out.println(String.format("Row affected %d", rowAffected));

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
		return "sucess";
    }
		else
		return "failed";
	}
	
	
	
	//@RequestMapping(method = RequestMethod.GET, value = "/updateToken" )
	//@ResponseBody
	public String getUpdatetoken(String userName, String token) throws SQLException 
	{   
		JdbcConnection dbc = new JdbcConnection();
		Connection connection = null;
		connection = dbc.getDBConnection();

        String sqlUpdate = "UPDATE country_data.securitylogin SET token = ?  WHERE userName=?";
             
        PreparedStatement statement = connection.prepareStatement(sqlUpdate);
        try  {
            
            statement.setString(1, token);
            statement.setString(2, userName);
           
            statement.executeUpdate();
       
            System.out.println(String.format("token updated"));

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
		return "sucess";
    }
	
	public User validateToken(String userName, String token) {
		Statement stmt = null;
		Connection conn = null;
		User usr= null;
		try {
			usr= new User();
			JdbcConnection dbc = new JdbcConnection();
			conn = dbc.getDBConnection();
			

			stmt = conn.createStatement();

			String sql = "SELECT userName,token FROM country_data.securitylogin where username = '" + userName + "' and token = '" + token +"'";
		   // System.out.println(sql);
			
			//UpdateDataServices update = null;
			//update.getUpdatetoken(userName,token);
			
			//TokenUtility utility = null;
			//token=utility.gernateToken(userName);
			//String result=update.getUpdatetoken(userName,token);
			
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				usr.setUserName(rs.getString("userName"));
				usr.setToken(rs.getString("token"));
		        
		    }
			return usr;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		}
		return usr;
	}
	
	
	}


