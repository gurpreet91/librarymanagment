package com.app.librarymanagment.webservice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.librarymanagment.model.BookDetails;
import com.app.librarymanagment.model.Credentials;
import com.app.librarymanagment.model.UserRegistration;
import com.app.librarymanagment.model.WebContextBean;
import com.app.librarymanagment.service.LibraryManagmentService;
import com.app.utils.ApplicationUtility;

@RestController
public class LibraryManagmentWebService {

	@Resource
	private LibraryManagmentService libraryManagmentService;

	@Resource
	List<UserRegistration> webContext;

	@Resource
	private WebContextBean webContextBean;

	@PostMapping("/login")
	public boolean isUserExist(@RequestBody Credentials credentials) {

		Map<String, String> usersCredentials = webContextBean.userCredentials;
		System.out.println("Inside the isUserExit");
		boolean isUserExist = libraryManagmentService.isUserExist(credentials,usersCredentials);
		return isUserExist;

	}

	@PostMapping("/saveRegistration")
	public boolean saveUserRegistration(@RequestBody UserRegistration userRegistration) {

		List<UserRegistration> listOfUserRegistration = new ArrayList<UserRegistration>();

		// listOfUserRegistration.add(userRegistration);
		// List<UserRegistration> webContext = (List<UserRegistration>) new
		// WebContextHolder().getSession().getAttribute("webContext");
		webContext.add(userRegistration);
		System.out.println(webContext.size());
		// new WebContextHolder().getSession().setAttribute("webContext",
		// webContext);
		return true;

	}

	@GetMapping("/home")
	public List<UserRegistration> getRegisteredUserInfo() {

		System.out.println("Here inside the getRegistered Info");
		// List<UserRegistration> registeredUser = (List<UserRegistration>) new
		// WebContextHolder().getSession().getAttribute("webContext");
		System.out.println("UserRegistration size in the home" + webContext.size());
		return webContext;

	}

	@GetMapping("/getBookDetails")
	public List<BookDetails> getBookDetails() {

		ArrayList<BookDetails> listOfBookDetails = new ArrayList<BookDetails>();
		listOfBookDetails.add(new BookDetails("Spring", "Durgesh", "07/07/2020"));
		listOfBookDetails.add(new BookDetails("Hibernate", "Monty", "07/07/2020"));
		listOfBookDetails.add(new BookDetails("Let C", "kohlin", "06/06/1990"));
		listOfBookDetails.add(new BookDetails("JAVA", "James Goslin", "06/06/1990"));
		return listOfBookDetails;

	}

	@PostMapping("/approve")
	public UserRegistration approveUser(@RequestBody UserRegistration userRegistration) {

		Map<String, String> userCredentials = webContextBean.userCredentials;
		List<UserRegistration> approvedUser = webContextBean.approvedUser;
		Iterator<UserRegistration> userRegList = webContext.iterator();

		while (userRegList.hasNext()) {

			UserRegistration userReg =(UserRegistration) userRegList.next();

			if (userReg.getMobileNumber().equals(userRegistration.getMobileNumber())) {
				String pwd = ApplicationUtility.registeredUserPassword();
				userCredentials.put(userRegistration.getEmail(), pwd);
				approvedUser.add(userReg);
				userRegList.remove();
			}

		}

		return userRegistration;
	}

	@PostMapping("/reject")
	public boolean rejectUser(@RequestBody UserRegistration userRegistration) {
		boolean isrejected = false;

		Iterator<UserRegistration> userRegList = webContext.iterator();

		while (userRegList.hasNext()) {
			UserRegistration userReg =(UserRegistration) userRegList.next();

			if (userReg.getMobileNumber().equals(userRegistration.getMobileNumber())) {
				userRegList.remove();
				isrejected = true;

			}

		}

		return isrejected;
	}

	@GetMapping("/getCredentials")
	public Map<String, String> getUserCredenials(){

		return  webContextBean.userCredentials;
	}

	@GetMapping("/registeredUsers")
	public List<UserRegistration> getRegisteredUserList() {

		System.out.println("Here inside the getRegistered Info");
		// List<UserRegistration> registeredUser = (List<UserRegistration>) new
		// WebContextHolder().getSession().getAttribute("webContext");
		System.out.println("UserRegistration size in the home" + webContextBean.approvedUser.size());
		return webContextBean.approvedUser;

	}

}
