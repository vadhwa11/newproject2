package jkt.hms.login.controller;

import java.security.InvalidKeyException;
import java.security.Key;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;

public class LocalEncrypter {

	private static String algorithm = "DESede";
	private static Key key = null;
	private static Cipher cipher = null;

	private static void setUp() throws Exception {
		key = KeyGenerator.getInstance(algorithm).generateKey();
		cipher = Cipher.getInstance(algorithm);
	}

	public static void main(String[] args) throws Exception {
		setUp();
		/*
		 * if (args.length !=1) { //System.out.println(
		 * "USAGE: java LocalEncrypter " + "[String]"); System.exit(1); }
		 */
		//System.out.println("key----:" + key);
		byte[] encryptionBytes = null;
		String input = "vikas is my name";
		//System.out.println("Entered: " + input);
		encryptionBytes = encrypt(input);
		for (int i = 0; i < encryptionBytes.length; i++) {
			//System.out.println("encryptionBytes: " + encryptionBytes[i]);
		}
		System.out.println("encryptionBytes: " + encryptionBytes);
		
		System.out.println("Recovered: " + decrypt(encryptionBytes));
	}

	private static byte[] encrypt(String input) throws InvalidKeyException,
			BadPaddingException, IllegalBlockSizeException {
		cipher.init(Cipher.ENCRYPT_MODE, key);
		byte[] inputBytes = input.getBytes();
		return cipher.doFinal(inputBytes);
	}

	private static String decrypt(byte[] encryptionBytes)
			throws InvalidKeyException, BadPaddingException,
			IllegalBlockSizeException {
		cipher.init(Cipher.DECRYPT_MODE, key);
		byte[] recoveredBytes = cipher.doFinal(encryptionBytes);
		String recovered = new String(recoveredBytes);
		return recovered;
	}
}
