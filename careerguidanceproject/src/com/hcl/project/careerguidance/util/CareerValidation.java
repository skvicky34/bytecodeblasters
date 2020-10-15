package com.hcl.project.careerguidance.util;

import java.util.regex.Pattern;

import static com.hcl.project.careerguidance.helper.ICareerConstants.EMAIL_PATTERN;
import static com.hcl.project.careerguidance.helper.ICareerConstants.PASSWORD_PATTERN;

/*
 * This class contains validation methods for the Career Guidance.
 */
public class CareerValidation {
	// This method contains user email validation logic.
	public static boolean isValidEmailAddress(String email) {

		if (email == null)
			return false;

		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		return pattern.matcher(email).matches();
	}

	// This method contains user password validation logic.
	public static boolean isValidPassword(String password) {

		if (password == null) {
			return false;
		}
		Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
		return pattern.matcher(password).matches();

	}

}
