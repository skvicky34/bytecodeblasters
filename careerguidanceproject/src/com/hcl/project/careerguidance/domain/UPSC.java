package com.hcl.project.careerguidance.domain;

import com.hcl.project.careerguidance.helper.ICareer;

public class UPSC implements ICareer {

	@Override
	public void competitiveExams() {

		System.out.println("List of UPSC Exams\r\n" + 
				"\r\n" + 
				"1.) Civil Services Examination\r\n" + 
				"2.) Engineering Services Examination(IES)\r\n" + 
				"3.) Combined Defence Services Examination(CDSE)\r\n" + 
				"4.) National Defence Academy Examination(NDA)\r\n" + 
				"5.) Naval Academy Examination\r\n" + 
				"6.) Combined Medical Services Examination\r\n" + 
				"7.) Special Class Railway Apprentice(SCRA)\r\n" + 
				"8.) Indian Economic Servce/Indian Statistical Service Examination\r\n" + 
				"9.) Geologists’ Examination(GE)\r\n" + 
				"10.) Central Armed Police Forces(AC)");
	}

}
