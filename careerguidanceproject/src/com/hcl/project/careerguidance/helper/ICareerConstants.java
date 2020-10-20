package com.hcl.project.careerguidance.helper;

import java.io.File;

/*
 * This interface contains all constants for Career Guidance.
 */
public interface ICareerConstants {

	String EMAIL_PATTERN = "^[_A-Za-z0-9+-]+(.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(.[A-Za-z0-9]+)*(.[A-Za-z]{2,})$";
	
	String PASSWORD_PATTERN = "^(?=.*[0-9])+(?=.*[a-z])(?=.*[A-Z])+(?=.*[@#$%^&+=])+(?=\\S+$).{8,15}$";
	
	File FILE = new File("C:\\Users\\user\\Desktop\\Project File\\Register.txt");
	
	String SECRET_KEY = "careerguidance";
	String SALT = "aassssbbnn!!!!";
	
	String MOBILE_NO_PATTERN = "^((0091)|(\\+91)|(0))?([7-9]{1})([0-9]{9})$";

}
