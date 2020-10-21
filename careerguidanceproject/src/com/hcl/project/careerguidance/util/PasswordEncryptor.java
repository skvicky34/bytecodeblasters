package com.hcl.project.careerguidance.util;

import java.security.spec.KeySpec;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import static com.hcl.project.careerguidance.helper.ICareerConstants.SALT;

/*
 * This class contains password encryption and decryption methods.
 */
public class PasswordEncryptor {
	
	/*
	 * This method encrypt a password (or any information) using AES 256 bits.
	 */
	public static String encrypt(String originalPassword, String secretKey) 
	{
	    try
	    {
	        byte[] initialValues = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	        IvParameterSpec ivspec = new IvParameterSpec(initialValues);
	         
	        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
	        KeySpec spec = new PBEKeySpec(secretKey.toCharArray(), SALT.getBytes(), 65536, 256);
	        SecretKey temp = factory.generateSecret(spec);
	        SecretKeySpec secretKeySpec = new SecretKeySpec(temp.getEncoded(), "AES");
	         
	        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
	        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivspec);
	        return Base64.getEncoder().encodeToString(cipher.doFinal(originalPassword.getBytes("UTF-8")));
	    } 
	    catch (Exception exp) 
	    {
	        System.out.println("Invalid 'password'");
	    }
	    return null;
	}
	
	/*
	 * This method decrypt a password (or any information) using AES 256 bits.
	 */
	public static String decrypt(String strToDecrypt, String secretKey) {
	    try
	    {
	        byte[] initialValues = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	        IvParameterSpec ivspec = new IvParameterSpec(initialValues);
	         
	        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
	        KeySpec spec = new PBEKeySpec(secretKey.toCharArray(), SALT.getBytes(), 65536, 256);
	        SecretKey temp = factory.generateSecret(spec);
	        SecretKeySpec secretKeySpec = new SecretKeySpec(temp.getEncoded(), "AES");
	         
	        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
	        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivspec);
	        return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
	    } 
	    catch (Exception exp) {
	        System.out.println("Invalid password'");
	    }
	    return null;
	}

}
