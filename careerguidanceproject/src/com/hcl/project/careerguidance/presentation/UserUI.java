package com.hcl.project.careerguidance.presentation;

import java.io.IOException;
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
import com.hcl.project.careerguidance.util.PasswordEncryptor;
import com.hcl.project.careerguidance.util.UserBO;
import com.hcl.project.careerguidance.util.UserDetailValidator;
import static com.hcl.project.careerguidance.helper.ICareerConstants.SECRET_KEY;

/*
 * This class contains main () method and represent as the UI of Career Guidance.
 * This is used to receive user input data and provide output based on the user choice.
 */
public class UserUI {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		String firstName, lastName, email, password, qualification, mobileNo;
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

			boolean flag = UserDetailValidator.isExistingUser(email, password);

			if (flag == false) {
				try {
					throw new ExtistingUserException();
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
				validEmail = UserDetailValidator.isValidEmailAddress(email);
				if (validEmail == false) {
					try {
						throw new InvalidInputDataException();
					} catch (InvalidInputDataException exc) {
						System.out.println("Invalid 'Email ID'!. Please provide correct 'Email ID' as per the rule");
						System.out.println("\nEnter the Email ID:");
						email = sc.nextLine();
					}
				}
				if (validEmail == false) {
					System.out.println("Invalid 'Email ID'!. Please provide correct 'Email ID' as per the rule");
				}
			} while (validEmail != true);

			boolean validPassword;
			System.out.print("\nPassword rules:\n" + "**Password should not contain any space.\n"
					+ "**Password should contain at least one digit(0-9), length [8 ~ 15], at least one lowercase letter(a-z) & (A-Z) and special character ( @, #, %, &, !, $, etc….).\n");
			do {
				System.out.println("\nEnter the Password:");
				password = sc.nextLine();
				validPassword = UserDetailValidator.isValidPassword(password);
				if (validPassword == false) {
					try {
						throw new InvalidInputDataException();
					} catch (InvalidInputDataException exc) {
						System.out
								.println("Invalid 'password'!. Please provide the correct 'password' as per the rule");
						System.out.println("\nEnter the Password:");
						password = sc.nextLine();
					}
				}
				if (validPassword == false) {
					System.out.println("Invalid 'password'!. Please provide the correct 'password' as per the rule");
				}
			} while (validPassword != true);

			String encryptedPassword = PasswordEncryptor.encrypt(password, SECRET_KEY);

			boolean validMobNo;
			System.out.println("\nMobile Number rules :\n**The first digit should contain number between 7 to 9."
					+ "The rest 9 digit can contain any number between 0 to 9.\n"
					+ "**Can have 11 digits also by including 0 at the starting.\n"
					+ "**Can be of 12 digits also by including +91 at the starting\n"
					+ "**Can be of 14 digits also by including 0091 at the starting\n");
			do {
				System.out.println("Enter the Mobile Number:");
				mobileNo = sc.nextLine();
				validMobNo = UserDetailValidator.isValidMobileNo(mobileNo);
				if (validMobNo == false) {
					try {
						throw new InvalidInputDataException();
					} catch (InvalidInputDataException exc) {
						System.out.println(
								"Invalid 'mobile number'!. Please provide the correct 'mobile number' as per the rule");
						System.out.println("\nEnter the Mobile Number:");
						mobileNo = sc.nextLine();
					}
				}
				if (validMobNo == false) {
					System.out.println(
							"Invalid 'mobile number'!. Please provide the correct 'mobile number' as per the rule");
				}
			} while (validMobNo != true);

			System.out.println("\nEnter the Qualifiation:");
			qualification = sc.nextLine();

			user = new User(firstName, lastName, email, encryptedPassword, mobileNo, qualification);
			try {
				UserBO.register(user);
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;

		default:
			System.err.println("Invalid selection!");
			System.exit(0);
		}

		int userOption = 0;
		do {
			System.out.println("---------------------------------------------------");
			System.out.println(
					"Enter area of interest:\n1) Engineering\n2) Banking Job\n3) Medical\n4) Railway Job\n5) SSC\n6) UPSC");

			int interest = sc.nextInt();
			System.out.println("---------------------------------------------------");
			ICareer career;

			switch (interest) {

			case 1:
				career = new Engineering();
				career.competitiveExams();
				System.out.println(
						"---------------------------------------------------\nEnter choice :\n1) Return to career choice menu\n2) Exit");
				userOption = sc.nextInt();
				if (userOption < 1 || userOption > 2) {
					System.err.println("Invalid choice!");
					System.exit(0);
				} else if (userOption == 2) {
					System.out.println("User has been exited successfully!");
					System.exit(0);
				}
				System.exit(0);
				break;

			case 2:
				Banking banking = new Banking();
				banking.jobType();
				banking.competitiveExams();
				System.out.println(
						"--------------------------------------------\nEnter choice :\n1) Return to career choice menu\n2) Exit");
				userOption = sc.nextInt();
				if (userOption < 1 || userOption > 2) {
					System.err.println("Invalid choice!");
					System.exit(0);
				} else if (userOption == 2) {
					System.out.println("User has been exited successfully!");
					System.exit(0);
				}
				break;

			case 3:
				career = new Medical();
				career.competitiveExams();
				System.out.println(
						"--------------------------------------------\nEnter choice :\n1) Return to career choice menu\n2) Exit");
				userOption = sc.nextInt();
				if (userOption < 1 || userOption > 2) {
					System.err.println("Invalid choice!");
					System.exit(0);
				} else if (userOption == 2) {
					System.out.println("User has been exited successfully!");
					System.exit(0);
				}
				break;

			case 4:
				career = new Railway();
				career.competitiveExams();
				System.out.println(
						"--------------------------------------------\nEnter choice :\n1) Return to career choice menu\n2) Exit");
				userOption = sc.nextInt();
				if (userOption < 1 || userOption > 2) {
					System.err.println("Invalid choice!");
					System.exit(0);
				} else if (userOption == 2) {
					System.out.println("User has been exited successfully!");
					System.exit(0);
				}
				break;

			case 5:
				career = new SSC();
				career.competitiveExams();
				System.out.println(
						"--------------------------------------------\nEnter choice :\n1) Return to career choice menu\n2) Exit");
				userOption = sc.nextInt();
				if (userOption < 1 || userOption > 2) {
					System.err.println("Invalid choice!");
					System.exit(0);
				} else if (userOption == 2) {
					System.out.println("User has been exited successfully!");
					System.exit(0);
				}
				break;

			case 6:
				career = new UPSC();
				career.competitiveExams();
				System.out.println(
						"--------------------------------------------\nEnter choice :\n1) Return to career choice menu\n2) Exit");
				userOption = sc.nextInt();
				if (userOption < 1 || userOption > 2) {
					System.err.println("Invalid choice!");
					System.exit(0);
				} else if (userOption == 2) {
					System.out.println("User has been exited successfully!");
					System.exit(0);
				}
				break;

			default:
				System.out.println("Invalid choice!");
				System.out.println(
						"---------------------------------------------------\nEnter choice :\n1) Return to career choice menu\n2) Exit");
				userOption = sc.nextInt();
				if (userOption < 1 || userOption > 2) {
					System.err.println("Invalid choice!");
					System.exit(0);
				} else if (userOption == 2) {
					System.out.println("User has been exited successfully!");
					System.exit(0);
				}
			}
		} while (userOption == 1);

	}

}
