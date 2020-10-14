package com.hcl.project.careerguidance.domain;

import java.util.Scanner;

import com.hcl.project.careerguidance.helper.ICareer;

public class Banking implements ICareer {

	@Override
	public void competitiveExams() {
		System.out.println("\nCompetitive Exams : \n1) Institute of Banking Personnel Selection Bank PO Exam (IBPS PO)\r\n"
				+ "2) Institute of Banking Personnel Selection Clerk Exam (IBPS Clerk)\r\n"
				+ "3) State Bank of India PO Exam (SBI PO)\r\n" 
				+ "4) State Bank of India Clerk Exam (SBI Clerk)\r\n"
				+ "5) State Bank of India Specialist Officer Exam (SBI SO)\r\n"
				+ "6) Reserve Bank of India Grade A Exam (RBI Grade I)\r\n"
				+ "7) Reserve Bank of India Grade B Exam (RBI Grade II)\r\n"
				+ "8) Institute of Banking Personnel Selection Regional Rural Bank Officer & Office Assistant Exam (IBPS RRB)\r\n"
				+ "9) ICICI PO Exam\r\n" 
				+ "10) Private Bank PO Exam\r\n"
				+ "11) National Bank for Agriculture and Rural Development Exam (NABARD)\r\n"
				+ "12) Industrial Development Bank of India Exam");

	}

	public void jobType() {
		System.out.println("Please select the job type from the list\n1) Bank PO\n2) Bank Clerk\n3) Specialist Officer");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		
		switch(choice) {
		
		case 1 : 
			System.out.println("----------------------------------------------------------------");
			System.out.println("Job Description :\n1) A bank PO has to manage multiple operations of a bank branch like Finance, Billing, Accounting and Investment.\r\n2) Bank PO has to address the customer complaints, Discrepancies in Accounts and Rectification of undue charges.\r\n3) Bank PO is involved in planning & managing loans, creating a budget and investment management.\n\nSalary : Rs 5.57 Lakh to Rs 8 Lakhs");
			System.out.println("\nElegibility Criteria :\n1) Age of the applicant must lie between 21 to 30 to apply for the Bank PO exam.\r\n2) Candidate must have a UG degree to apply for the Bank PO exam.\r\n3) There must be no criminal record against the applicant.");
		break;
		
		case 2 :
			System.out.println("----------------------------------------------------------------");
			System.out.println("Job Description :\n1) A Bank Clerk deals with the customers directly.\r\n2) Ensures all the documents are correct while opening a new account.\r\n3) Updates customer accounts.\r\n4) Calls up customers for advances.\n\nSalary : Rs 3 Lakhs to Rs 3.8 Lakhs");
			System.out.println("\nElegibility Criteria :\n1) Candidates applying for Bank Clerk Exam must be 20 to 28 years old.\r\n2) Candidates must possess a graduate degree in any stream and specialisation from a well-recognized university.\r\n3) Applicants must not hold any criminal record while applying for Bank Clerk Exam.");
		break;
		
		case 3 :
			System.out.println("----------------------------------------------------------------");
			System.out.println("Job Description :\n1) A role of Specialist Officer varies as per the position.\r\n2) Some of the positions of SO in banks are - IT Officer, Marketing Officer, Law Officer, Human Resource Manager and Agricultural Officer.\r\n3) Role of each Specialist Officer is to handle all the operations falling under their department.\n\nSalary : Rs 4 Lakhs to Rs 4.6 Lakhs");
			System.out.println("\nElegibility Criteria :\n1) There are different positions offered under the Bank SO Examination with different age limits. in general, the minimum age for Bank SO is 21 and the maximum is 45 years.\r\n2) Applicants must have a graduation degree to apply for the Bank SO posts, however, the educational qualification may vary according to the post candidate is applying for.");
		break;
		
		default :
			System.err.println("Invalid choice!!!");
			System.exit(0);
		}
	}
}
