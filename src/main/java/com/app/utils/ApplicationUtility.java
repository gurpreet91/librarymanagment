package com.app.utils;

import java.util.Random;

public class ApplicationUtility {
	
	public static String registeredUserPassword() {

		String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String Small_chars = "abcdefghijklmnopqrstuvwxyz";
		String numbers = "0123456789";
		String symbols = "!@#$%^&*_=+-/.?<>)";

		String values = Capital_chars + Small_chars + numbers + symbols;

		Random rndm_method = new Random();

		char[] password = new char[10];

		for (int i = 0; i < 10; i++) {

			password[i] = values.charAt(rndm_method.nextInt(values.length()));

		}
		return String.valueOf(password);
	}
}
