package com.hcl.project.careerguidance.util;

import static com.hcl.project.careerguidance.helper.ICareerConstants.EMAIL_PATTERN;
import static com.hcl.project.careerguidance.helper.ICareerConstants.PASSWORD_PATTERN;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

import com.hcl.project.careerguidance.helper.ICareerConstants;

/*
 * This class contains validation methods for the Career Guidance.
 */
public class UserDetailValidator {
	

	/**
	 * This method contains user email validation logic.
	 * 
	 * @param email
	 * @return returns true if email is valid otherwise false.
	 */
	public static boolean isValidEmailAddress(String email) {

		if (email == null)
			return false;

		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		return pattern.matcher(email).matches();
	}

	/**
	 * This method contains user password validation logic.
	 * 
	 * @param password
	 * @return returns true if password is valid otherwise false.
	 */
	public static boolean isValidPassword(String password) {

		if (password == null) {
			return false;
		}
		Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
		return pattern.matcher(password).matches();
	}
	
	@SuppressWarnings("resource")
	public static boolean isExistingUser(String email, String password) {
		try {
			FileReader reader = new FileReader(ICareerConstants.FILE);
			BufferedReader bufferedReader = new BufferedReader(reader);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				String[] data = line.split(",");
				if (data.length != 0) {
					if (data[3].equals(email) && data[4].equals(password)) {
						reader.close();
						return true;
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

}
