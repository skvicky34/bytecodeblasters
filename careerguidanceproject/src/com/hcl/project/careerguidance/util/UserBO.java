package com.hcl.project.careerguidance.util;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import com.hcl.project.careerguidance.helper.ICareerConstants;
import com.hcl.project.careerguidance.pojo.User;

public class UserBO {

	public static void register(User user) throws IOException {
		try {
			if (!ICareerConstants.FILE.exists()) {
				ICareerConstants.FILE.createNewFile();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		FileWriter outputStream = null;
		try {
			outputStream = new FileWriter(ICareerConstants.FILE, true);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		BufferedWriter bufferedWriter = new BufferedWriter(outputStream);
		bufferedWriter.write(user.getFirstName() + "," + user.getLastName() + "," + user.getMobileNo() + ","
				+ user.getEmailId() + "," + user.getPassword() + "," + user.getQualifiation());
		bufferedWriter.newLine();
		bufferedWriter.flush();
		bufferedWriter.close();
		user.saveEmailAndPassword();
		System.out.println("\nSuccessfully registered!!");

	}

}
