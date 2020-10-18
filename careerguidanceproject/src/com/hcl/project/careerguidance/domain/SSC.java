package com.hcl.project.careerguidance.domain;

import com.hcl.project.careerguidance.helper.ICareer;

/*
 * This class contains SSC jobs and competitive examination details.
 */
public class SSC implements ICareer {

	@Override
	public void competitiveExams() {
		
		System.out.println("List of SSC Exams\r\n" + 
				"\r\n" + 
				"1.) SSC JE Tier I 2020\r\n" + 
				"2.) SSC JE Tier II 2020\r\n" + 
				"3.) SSC CGL Tier II 2020\r\n" + 
				"4.) SSC Stenographer 2020");
	}

}
