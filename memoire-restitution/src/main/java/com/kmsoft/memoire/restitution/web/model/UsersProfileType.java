package com.kmsoft.memoire.restitution.web.model;

import java.io.Serializable;

public enum UsersProfileType implements Serializable{
	USER("USER"),
	ADMIN("ADMIN");
	String userProfileType;
	
	private UsersProfileType(String userProfileType){
		this.userProfileType = userProfileType;
	}
	
	public String getUserProfileType(){
		return userProfileType;
	}
	
}
