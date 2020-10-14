package com.hcl.project.careerguidance.presentation;

import java.util.Scanner;

import com.hcl.project.careerguidance.domain.Banking;
import com.hcl.project.careerguidance.domain.Engineering;
import com.hcl.project.careerguidance.domain.Medical;
import com.hcl.project.careerguidance.domain.Railway;
import com.hcl.project.careerguidance.domain.SSC;
import com.hcl.project.careerguidance.domain.UPSC;
import com.hcl.project.careerguidance.helper.ExtistingUserException;
import com.hcl.project.careerguidance.pojo.User;

public class UserUI {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		String firstName, lastName, email, password, mobileNo, qualification;
		User user;

		System.out.println(
				"***********Welcome to the Career Guidance System!!***********\nPlease select the an option from the below\n1) Existing user\n2) New User");

		int choice = sc.nextInt();
		sc.nextLine();

		switch (choice) {
		
		case 1:
			System.out.println("Enter the email id:");
			email = sc.nextLine();

			System.out.println("\nEnter the password:");
			password = sc.nextLine();

			user = new User();

			boolean flag = user.validateUser(email, password);

			if (flag == false) {
				try {
					throw new ExtistingUserException("Invalid 'email id' or 'password'");
				} catch (ExtistingUserException e) {
					System.err.println("Invalid 'email id' or 'password'");
					System.exit(0);
				}
			}
			break;

		case 2:

			System.out.println("\nEnter the First Name:");
			firstName = sc.nextLine();

			System.out.println("\nEnter the Last Name:");
			lastName = sc.nextLine();

			System.out.println("\nEnter the Email ID:");
			email = sc.nextLine();

			System.out.println("\nEnter the Password:");
			password = sc.nextLine();

			System.out.println("\nEnter the Mobile Number:");
			mobileNo = sc.nextLine();

			System.out.println("\nEnter the Qualifiation:");
			qualification = sc.nextLine();

			user = new User(firstName, lastName, email, password, mobileNo, qualification);
			break;
			
		default:
			System.err.println("Invalid selection!");
			System.exit(0);
		}

		System.out.println("---------------------------------------------------");
		System.out.println(
				"Enter area of interest:\n1) Engineering\n2) Banking Job\n3) Medical\n4) Railway Job\n5) SSC\n6) UPSC");

		int interest = sc.nextInt();

		switch (interest) {
		
		case 1:
			Engineering eng = new Engineering();
			eng.competitiveExams();
			eng.computeEligibility();
			break;

		case 2:
			Banking banking = new Banking();
			banking.jobType();
			banking.competitiveExams();
			break;

		case 3:
			Medical medical = new Medical();
			break;

		case 4:
			Railway railway = new Railway();
			break;

		case 5:
			SSC ssc = new SSC();
			break;

		case 6:
			UPSC upsc = new UPSC();
			upsc.competitiveExams();
			break;

		default:
			System.err.println("Invalid choice!");
			System.exit(0);
		}

	}

}
