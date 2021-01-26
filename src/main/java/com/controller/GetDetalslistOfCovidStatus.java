package com.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.dataBase.JdbcConnection;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.pojo.TotalNationalCases;

@Controller
public class GetDetalslistOfCovidStatus extends JdbcConnection {

	@RequestMapping(method = RequestMethod.GET, value = "/getDetailsOfCovidList2")
	@ResponseBody
	public List<TotalNationalCases> registerStudent() {
		System.out.println("Input call for CovidListDetails 2");
		
		List<TotalNationalCases> arrlist = new ArrayList<TotalNationalCases>();
		Connection conn = null;
		GetDetalslistOfCovidStatus nationalList=new GetDetalslistOfCovidStatus();
		conn= nationalList.getDBConnection();
        
		try {
		 
//		            conn = DriverManager.getConnection(jdbcURL, username, password);
//		            conn.setAutoCommit(false);
		        	
		            
					Statement st=  conn.createStatement();
					ResultSet rs=st.executeQuery("SELECT * FROM `statedata`");
					TotalNationalCases usrDtls= null;
						while (rs.next()) {
							usrDtls = new TotalNationalCases();
							usrDtls.setCountry(rs.getString("state"));		
							usrDtls.setConfirmed(Integer.parseInt(rs.getString("confirmed")));
							usrDtls.setActive(Integer.parseInt(rs.getString("active")));
							usrDtls.setRecovered(Integer.parseInt(rs.getString("recovered")));
							usrDtls.setDeath(Integer.parseInt(rs.getString("death")));
						
							arrlist.add(usrDtls);
							break;
					    }
						//return resultArr;
		        }
		        catch (SQLException ex) {
		            ex.printStackTrace();
		        }
		return arrlist;
		
}
		
		
		
		
//		TotalNationalCases cldtls = new TotalNationalCases();
//		cldtls.setSrno(1);
//		cldtls.setCountry("Delhi");
//		cldtls.setConfirmed(3000085);
//		cldtls.setRecovered(3000085);
//		cldtls.setActive(30085);
//		cldtls.setDeath(50);
//		
//		arrlist.add(cldtls);
//		
		
//		return arrlist ;
//	}
}
