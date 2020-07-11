package com.app.librarymanagment.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebContextBean {
	public List<UserRegistration> webContext= new ArrayList<UserRegistration>();
	public  List<UserRegistration> approvedUser= new ArrayList<UserRegistration>();
	public Map<String,String> userCredentials= new HashMap<String, String>();



}
