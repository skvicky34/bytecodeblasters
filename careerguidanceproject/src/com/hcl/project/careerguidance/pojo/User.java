package com.hcl.project.careerguidance.pojo;

import java.util.HashMap;
import java.util.Map;

public class User {

	private String firstName;
	private String lastName;
	private String emailId;
	private String password;
	private String mobileNo;
	private String qualifiation;

	public User() {
	}

	public User(String firstName, String lastName, String emailId, String password, String mobileNo,
			String qualifiation) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.password = password;
		this.mobileNo = mobileNo;
		this.qualifiation = qualifiation;
		saveEmailAndPassword(this.emailId, this.password);
		System.out.println("\nUser has been saved successfully!!!");
	}

	Map<String, String> map = new HashMap<>();


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getQualifiation() {
		return qualifiation;
	}

	public void setQualifiation(String qualifiation) {
		this.qualifiation = qualifiation;
	}

	// User validation
	public boolean validateUser(String email, String password) {
		if (map.containsKey(email)) {
			if (map.get(email).equals(password)) {
				return true;
			}
		}
		return false;
	}
	
	public Map<String, String> saveEmailAndPassword(String emailId, String password) {
		map.put(emailId, password);
		return map;
	}

	@Override
	public String toString() {
		return "firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId + ", password=" + password
				+ ", mobileNo=" + mobileNo + ", qualifiation=" + qualifiation;
	}

}
