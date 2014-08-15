package com.philosophy;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;


public class LicenseGen {
	private String license = null;

	public LicenseGen(String text) {
		license = text;
		byte[] keyBytes = { 88, 42, 94, 52, 56, 81, 82, 98 };
		System.out.println("Original License : " + license);
		try {
			SecretKey key = new SecretKeySpec(keyBytes, "DES");
			Cipher cipher = Cipher.getInstance("DES");
			byte[] data = license.getBytes();
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] encrypted = cipher.doFinal(data);
			System.out.println("Encrypted license : " + new String(encrypted));
			//now convert to base64
			byte[] base64Enc = Base64.encodeBase64(encrypted);
			String encodedLicense = new String(base64Enc);
			System.out.println("Encoded license is : " + encodedLicense);
			System.out.println("Encoding string length is : " + encodedLicense.length());
		}
		catch (NoSuchAlgorithmException e) {
		}
		catch (NoSuchPaddingException e) {
		}
		catch (InvalidKeyException e) {
		}
		catch (IllegalStateException e) {
		}
		catch (IllegalBlockSizeException e) {
		}
		catch (BadPaddingException e) {
		}
	}


	public static void main(String[] args) {
		//LicenseGen lg = new LicenseGen(args[0].toString());
		new LicenseGen("ABR012016113099999999");
	}

}
