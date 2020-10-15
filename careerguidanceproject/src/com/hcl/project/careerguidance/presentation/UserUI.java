package com.hcl.project.careerguidance.presentation;

import java.util.Scanner;

import com.hcl.project.careerguidance.domain.Banking;
import com.hcl.project.careerguidance.domain.Engineering;
import com.hcl.project.careerguidance.domain.Medical;
import com.hcl.project.careerguidance.domain.Railway;
import com.hcl.project.careerguidance.domain.SSC;
import com.hcl.project.careerguidance.domain.UPSC;
import com.hcl.project.careerguidance.exception.ExtistingUserException;
import com.hcl.project.careerguidance.exception.InvalidInputDataException;
import com.hcl.project.careerguidance.helper.ICareer;
import com.hcl.project.careerguidance.pojo.User;
import com.hcl.project.careerguidance.util.CareerValidation;

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

			boolean validEmail;
			System.out.print("\nEmail rules:\n"
					+ "**[_A-Za-z0-9-\\+]+ must start with string in the bracket [ ], must contains one or more (+)\n"
					+ "** @ # must contains a \"@\" symbol\n"
					+ "** Email should contain at least one lowercase letter(a-z), one uppercase letter(A-Z) and one special character ( @, #, %, &, !, $, etc….).\n");
			do {
				System.out.println("\nEnter the Email ID:");
				email = sc.nextLine();
				validEmail = CareerValidation.isValidEmailAddress(email);
				if (validEmail == false) {
					try {
						throw new InvalidInputDataException(
								"Invalid 'Email ID!'. Please provide correct 'Email ID' as per the rule");
					} catch (InvalidInputDataException exc) {
						System.out.println(
								"Invalid 'Email ID'!. Please provide correct 'Email ID' as per the rule");
						System.out.println("\nEnter the Email ID:");
						email = sc.nextLine();
					}
				}
			} while (validEmail != true);
			
			boolean validPassword;
			System.out.print("\nPassword rules:\n"
					+ "**Password should not contain any space.\n"
					+ "**Password should contain at least one digit(0-9), length [8 ~ 15], at least one lowercase letter(a-z) & (A-Z) and special character ( @, #, %, &, !, $, etc….).\n");
			do {
				System.out.println("\nEnter the Password:");
				password = sc.nextLine();
				validPassword = CareerValidation.isValidPassword(password);
				if (validPassword == false) {
					try {
						throw new InvalidInputDataException(
								"Invalid 'password'!. Please provide the correct 'password' as per the rule");
					} catch (InvalidInputDataException exc) {
						System.err.println(
								"IInvalid 'password'!. Please provide the correct 'password' as per the rule");
						System.out.println("\nEnter the Password:");
						password = sc.nextLine();
					}
				}
			} while (validPassword != true);

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
		
		ICareer career;

		switch (interest) {
		
		case 1:
			career = new Engineering();
			career.competitiveExams();
			break;

		case 2:
			Banking banking = new Banking();
			banking.jobType();
			banking.competitiveExams();
			break;

		case 3:
			career = new Medical();
			career.competitiveExams();
			break;

		case 4:
			career = new Railway();
			career.competitiveExams();
			break;

		case 5:
			career = new SSC();
			career.competitiveExams();
			break;

		case 6:
			career = new UPSC();
			career.competitiveExams();
			break;

		default:
			System.err.println("Invalid choice!");
			System.exit(0);
		}

	}

}
