package com.hcl.project.careerguidance.util;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import com.hcl.project.careerguidance.helper.ICareerConstants;
import com.hcl.project.careerguidance.pojo.User;

public class UserBO {
	//static File file = new File("C:\\Users\\user\\Desktop\\Project File\\Register.txt");

	public static void register(User user) throws IOException {
		try {
			if (!ICareerConstants.FILE.exists()) {
				ICareerConstants.FILE.createNewFile();
			} else {
				System.out.println("File already exists.");
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

	/*@SuppressWarnings("resource")
	public static boolean validate(String email, String password) {
		try {
			FileReader reader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(reader);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				String[] data = line.split(",");
				if (data.length != 0) {
					if (data[3].equals(email) && data[4].equals(password)) {
						reader.close();
						return true;
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}*/
}
