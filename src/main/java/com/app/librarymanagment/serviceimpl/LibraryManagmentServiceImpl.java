package com.app.librarymanagment.serviceimpl;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.app.librarymanagment.constant.ApplicationConstants;
import com.app.librarymanagment.model.Credentials;
import com.app.librarymanagment.service.LibraryManagmentService;

@Service
public class LibraryManagmentServiceImpl implements LibraryManagmentService {
	ApplicationContext applicationContext=null;
	@Override
	public boolean isUserExist(Credentials credentials,Map<String,String>usersCredentials) {
		Boolean isUserExist = false;

		if(usersCredentials.containsKey(credentials.getUserName()) && usersCredentials.containsValue(credentials.getPassword())){
			isUserExist=true;
		}


		return isUserExist;
	}

}
