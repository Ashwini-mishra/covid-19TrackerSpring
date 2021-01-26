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
import com.pojo.StateData;


@Controller
public class GetDetailOfCovid19Status  {
	

	@RequestMapping(method = RequestMethod.GET, value = "/getDetailsOfCovidList5")
		@ResponseBody
		public List<StateData> registerStudent() {
		JdbcConnection dbc = new JdbcConnection();
		Connection conn = null;
		List<StateData> resultArr = new ArrayList<StateData>();
			System.out.println("Input call for CovidListDetails 5");
			
			//GetDetailOfCovid19Status cdm=new GetDetailOfCovid19Status();
			conn= dbc.getDBConnection();
	        
			try {
						Statement st=  conn.createStatement();
						ResultSet rs=st.executeQuery("SELECT * FROM `statedata`");
						StateData usrDtls= null;
							while (rs.next()) {
								usrDtls = new StateData();
								usrDtls.setState(rs.getString("state"));		
								usrDtls.setConfirmed(Integer.parseInt(rs.getString("confirmed")));
								usrDtls.setActive(Integer.parseInt(rs.getString("active")));
								usrDtls.setRecovered(Integer.parseInt(rs.getString("recovered")));
								usrDtls.setDeath(Integer.parseInt(rs.getString("death")));
								resultArr.add(usrDtls);
								
						    }
			        }
			        catch (SQLException ex) {
			            ex.printStackTrace();
			        }
			catch(NumberFormatException ex){
				 ex.printStackTrace();
			}
			return resultArr;
			
	}
			
			
			
//			List<StateData> arrlist = new ArrayList<StateData>();
//			
//			StateData cldtls = new StateData();
//			cldtls.setSrno(1);
//			cldtls.setState("Delhi");
//			cldtls.setConfirmed(3000085);
//			cldtls.setRecovered(3000085);
//			cldtls.setActive(30085);
//			cldtls.setDeath(50);
//			
//			arrlist.add(cldtls);
//			
//			cldtls = new StateData();
//			cldtls.setSrno(2);
//			cldtls.setState("Maharastra");
//			cldtls.setConfirmed(40085);
//			cldtls.setRecovered(4085);
//			cldtls.setActive(2285);
//			cldtls.setDeath(40);
//			
//			arrlist.add(cldtls);
//			
//			cldtls = new StateData();
//			cldtls.setSrno(3);
//			cldtls.setState("Bihar");
//			cldtls.setConfirmed(8435);
//			cldtls.setRecovered(3984);
//			cldtls.setActive(855678);
//			cldtls.setDeath(25);
//			
//			
//			arrlist.add(cldtls);
//			
//			cldtls = new StateData();
//			cldtls.setSrno(4);
//			cldtls.setState("Karnataka");
//			cldtls.setConfirmed(7006);
//			cldtls.setRecovered(653);
//			cldtls.setActive(5876);
//			cldtls.setDeath(45);
//			
//			arrlist.add(cldtls);
//			
//			cldtls = new StateData();
//			cldtls.setSrno(5);
//			cldtls.setState("Bengal");
//			cldtls.setConfirmed(85468);
//			cldtls.setRecovered(653);
//			cldtls.setActive(7676);
//			cldtls.setDeath(70);
//			
//			arrlist.add(cldtls);
//			
//			return arrlist ;
		
	}


