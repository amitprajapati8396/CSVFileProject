package com.app.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.service.UserService;


@Controller
@Validated
public class UserController {
	@Autowired
	UserService service;
	@RequestMapping("/home")
	public String home(){
		return "home";
	}
	@RequestMapping("/address")
	public String getAllAddress(Model model){
		 model.addAttribute("address",service.getAllAddress());
		return "address";
	}
	@RequestMapping("/users")
	public String getAllUsers(Model model){
		 model.addAttribute("users",service.getAllUsers());
		 System.out.println(service.getAllUsers());
		return "user";
	}
	@RequestMapping("/save")
	public ResponseEntity<String> saveUser() throws NumberFormatException, IOException{
		
	   service.saveUser();      
      return ResponseEntity.ok("data saved successfully...");
     }
		
	}

