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


public class LicenseDecoder {
	private String license = null;

	public LicenseDecoder(String text) {
		license = text;
		byte[] keyBytes = { 88, 42, 94, 52, 56, 81, 82, 98 };
		System.out.println("Original License : " + license);
		try {
			SecretKey key = new SecretKeySpec(keyBytes, "DES");
			Cipher cipher = Cipher.getInstance("DES");
			byte[] decoded = Base64.decodeBase64(license.getBytes());
			cipher.init(Cipher.DECRYPT_MODE, key);
			byte[] decrypted = cipher.doFinal(decoded);
			System.out.println("Decrypted license : " + new String(decrypted));
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
	    String lic = "hFFawMG7tMqnRtESKF5Dypjg+Ce/l6/A";
	    new LicenseDecoder(lic);
	    
	    /*
	    if (args.length > 0) {
	        LicenseDecoder ld = new LicenseDecoder(args[0].toString());
	    }
	    else {
	        LicenseDecoder ld = new LicenseDecoder(lic);
	    }*/
	}

}
