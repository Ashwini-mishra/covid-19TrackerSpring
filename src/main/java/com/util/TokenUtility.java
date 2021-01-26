package com.util;

import java.util.Random;

public class TokenUtility {
	
	public String gernateToken(String userName) {
		//TokenUtility obj =  new TokenUtility();
		//all code maintain exception try catch
		String token ="";
		// random no 128 character
		
		// once generate then save token in DB 
		//obj.saveToken(token,userName);
		
	try {
		int n=userName.length()+15;

		// lower limit for LowerCase Letters 
		int lowerLimit = 97; 

		// lower limit for LowerCase Letters 
		int upperLimit = 122; 

		Random random = new Random(); 

		// Create a StringBuffer to store the result 
		StringBuffer r = new StringBuffer(n); 

		for (int i = 0; i < n; i++) { 

			// take a random value between 97 and 122 
			int nextRandomChar = lowerLimit 
								+ (int)(random.nextFloat() 
										* (upperLimit - lowerLimit + 1)); 

			// append a character at the end of bs 
			r.append((char)nextRandomChar); 
		} 
		token= r.toString();
		//System.out.println(token);
	}
	catch(Exception e)
	{
		System.out.println("error");
	}
	// return the resultant string 
	//return r.toString();
	return token;	
	} 
	
	

//	public boolean saveToken(String token, String userName) {
//		//if sucessfull save return true else false
//		// save in DB , id , username, token, creation timestamp
//		return false;
//	}
	
//	public boolean vallidateToken(String token, String userName) {
//		// in db search token based on username if found retun true else false
//		return false;
//	}
}
