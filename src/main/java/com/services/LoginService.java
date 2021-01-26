package com.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.dao.RegisterUserDao;
//import com.pojo.LoginRequest;
import com.pojo.LoginResponse;
import com.pojo.User;


@Controller
public class LoginService {
	@RequestMapping(method = RequestMethod.POST, value = "/login" )
	@ResponseBody
	public List<LoginResponse> getCountries(String user, String pass)throws Exception 
	{
		List<LoginResponse> loginResponse = new ArrayList<LoginResponse>();
		LoginResponse lr = new LoginResponse();
		
		RegisterUserDao regDao = new RegisterUserDao();
		User UserDtl = new User();
		
    	//System.out.println(user);
    	
    	//LoginRequest logReq =  new LoginRequest();
  	
    	if(!user.equals("") && !pass.equals("") ) {
    		
    		UserDtl = regDao.fetchUserDetailsByUserIdPassword(user, pass);
    		if(UserDtl.getPassword()!=null && UserDtl.getUserName()!=null) {
    			/*generate token based on user name  and save this token in database and return same token to login response 
    			 * because same response token can use for other service to validate it is right or wrong user 
    			 * why token is important because we are not sending password in login response and its not safe way to
    			 * send clear text password for every web service call example (add patient name, add city, add new case)
    			 * 
    			 * we are using our own token mechanism but actually enterprise application use 128 bit sourceforge SSO or any sso implementation
    			 */
    			lr.setToken(UserDtl.getToken());
    			lr.setStatus("sucess");
        		lr.setUserName(UserDtl.getUserName());
        		loginResponse.add(lr);
        		return loginResponse;
    			
    		}else {
    			lr.setStatus("fail");
        		loginResponse.add(lr);
        		return loginResponse;
    		}
    	}else {
    		lr.setStatus("fail");
    		loginResponse.add(lr);
    		return loginResponse;
    	}
    	
	
	}

}
