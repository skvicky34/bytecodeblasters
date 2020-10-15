package com.hcl.project.careerguidance.domain;

import com.hcl.project.careerguidance.helper.ICareer;

public class Railway implements ICareer{

	@Override
	public void competitiveExams() {
		
		System.out.println("List of Exams conducted by the Railway Recruitment Board(RRB) are:\r\n" + 
				"\r\n" + 
				"1.) RRB (Assistant Loco Pilot) ALP. The basic educational requirement and age limit for the RRB ALP exam is: ... \r\n" + 
				"2.) RRB Junior Engineer JE.\r\n" + 
				"3.) RRB Non-Technical Popular Categories (NTPC): \r\n" + 
				"4.) RRB Group D:");
		
	}

}
