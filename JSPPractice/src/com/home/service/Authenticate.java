package com.home.service;

import com.home.entity.User;

public class Authenticate {
	String nameFromDb = "Rezaul";
	String passFromDb = "password";
	public String authenticate(User u){
		if(u.getName()!=null&&u.getName().equals(nameFromDb)&&u.getPass()!=null&&u.getPass().equals(passFromDb)){
			return nameFromDb;
		}
		else{
			return "fail";
		}
	}
}
