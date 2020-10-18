package com.hcl.project.careerguidance.pojo;

import java.util.HashMap;
import java.util.Map;

/*
 * This class is used to hold User details.
 */
public class User {

	private String firstName;
	private String lastName;
	private String emailId;
	private String password;
	private long mobileNo;
	private String qualifiation;

	public User() {
	}

	public User(String firstName, String lastName, String emailId, String password, long mobileNo,
			String qualifiation) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.password = password;
		this.mobileNo = mobileNo;
		this.qualifiation = qualifiation;
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

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getQualifiation() {
		return qualifiation;
	}

	public void setQualifiation(String qualifiation) {
		this.qualifiation = qualifiation;
	}

	public Map<String, String> saveEmailAndPassword() {
		map.put(this.emailId, this.password);
		System.out.println(map.get(this.emailId));
		return map;
	}

}
