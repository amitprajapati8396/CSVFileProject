package com.app.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entities.Address;
import com.app.entities.User;
import com.app.repository.AddressRepository;
import com.app.repository.UserRepository;

@Service
public class UserService {
   @Autowired
   UserRepository repo;
   @Autowired
   AddressRepository addrRepo;
  
   // save user Method
   
   String line="";
   public void saveUser() throws IOException{
	   
	 	BufferedReader bf=new BufferedReader(new FileReader("src/main/resources/userfile.csv"));  
       while((line=bf.readLine())!=null) {
    	   String[] data=line.split(",");
    	   User user=new User();
 	       Address addr=new Address();
    	   	   
    	   user.setFname(data[0]);
    	   user.setLname(data[1]);    	   
    	   user.setAge(Integer.parseInt(data[2]));
    	   
    	   addr.setLine1(data[3]);
    	   addr.setLine2(data[4]);
    	   addr.setCity(data[5]);
    	   addr.setState(data[6]);
    	   addr.setCountry(data[7]);
    	   addr.setPostalno(Integer.parseInt(data[8]));
    	   repo.save(user);
    	   addrRepo.save(addr);
       }
   }
   
   //get user method
    public  Iterable<User> getAllUsers(){
    	return repo.findAll();
    }
  //get address method
    public  Iterable<Address> getAllAddress(){
    	return addrRepo.findAll();
    }

	
}
