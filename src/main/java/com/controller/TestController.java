package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

		@RequestMapping(method = RequestMethod.GET, value = "/register/student")
		@ResponseBody
		public String registerStudent() {
			System.out.println("In registerStudent");
			return "test suceesfull" ;
		}
		
		@RequestMapping(method = RequestMethod.GET, value = "/register/student2")
		@ResponseBody
		public String registerStudent2() {
			System.out.println("In registerStudent");
			return "test suceesfull2" ;
		}

}
