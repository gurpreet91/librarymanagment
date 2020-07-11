package com.app.librarymanagment.applicationconfig;

import java.util.ArrayList;
import java.util.List;

import com.app.librarymanagment.model.WebContextBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.app.librarymanagment.model.UserRegistration;
@Configuration
public class AppConfiguration {
	@Bean("webContext")
	public List<UserRegistration> getWebContext() {
		return new ArrayList<UserRegistration>();
	}
	@Bean("webContextBean")
	public WebContextBean getWebContextBean() {
		return  new WebContextBean();
	}
}
