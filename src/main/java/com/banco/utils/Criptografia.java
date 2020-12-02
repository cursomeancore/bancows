// Criptografia.java

package com.banco.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class Criptografia {

	public static String SHA3(String str) {
		try {
			final MessageDigest digest = MessageDigest.getInstance("SHA3-256");
			final byte[] hashbytes = digest.digest(str.getBytes(StandardCharsets.UTF_8));
			return bytesToHex(hashbytes);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private static String bytesToHex(byte[] hash) {
		StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < hash.length; i++) {
			String hex = Integer.toHexString(0xff & hash[i]);
			if (hex.length() == 1)
				hexString.append('0');
			hexString.append(hex);
		}
		return hexString.toString();
	}
}