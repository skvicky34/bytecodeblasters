package com.hcl.project.careerguidance.helper;

public interface ICareerConstants {

	String EMAIL_PATTERN = "^[_A-Za-z0-9+-]+(.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(.[A-Za-z0-9]+)*(.[A-Za-z]{2,})$";
	
	String PASSWORD_PATTERN = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])"+ "(?=\\S+$).{8,15}$";

}
