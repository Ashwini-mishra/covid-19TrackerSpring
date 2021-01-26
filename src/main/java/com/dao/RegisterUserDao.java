
package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.dataBase.JdbcConnection;
import com.pojo.User;
import com.services.UpdateDataServices;
import com.util.TokenUtility;

public class RegisterUserDao{
	
	 UpdateDataServices update=new UpdateDataServices() ;

	public User fetchUserDetailsByUserIdPassword(String userName, String pass) throws Exception{
		Statement stmt = null;
		Connection conn = null;
		TokenUtility utility = new TokenUtility() ;
		User usr= null;
		try {
			usr= new User();
			JdbcConnection dbc = new JdbcConnection();
			conn = dbc.getDBConnection();
			

			stmt = conn.createStatement();

			String sql = "SELECT userName,password,token FROM country_data.securitylogin where userName = '" + userName + "' and password = '" + pass +"'";
		    //System.out.println(sql);
			
			
			String token=utility.gernateToken(userName);
			String result=update.getUpdatetoken(userName,token);
			// System.out.println(token);
		
			if(result.equals("sucess"))
			{
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				usr.setUserName(rs.getString("userName"));
				usr.setPassword(rs.getString("password"));
				usr.setToken(rs.getString("token"));    
		    }
			return usr;
			}
			else
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
