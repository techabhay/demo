package com.example.demo.utils;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class AesEncryption4 {

	private static final String SECRET_KEY = "my_secret_key";
	private static final String SALT = "my_salt_key";

	public static SecretKey generateKey(int n) throws NoSuchAlgorithmException, InvalidKeySpecException {
		SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
		KeySpec spec = new PBEKeySpec(SECRET_KEY.toCharArray(), SALT.getBytes(), 65536, 256);
		SecretKey key = factory.generateSecret(spec);
		return key;
	}

	public static IvParameterSpec generateIv() {
		byte[] iv = new byte[16];
		new SecureRandom().nextBytes(iv);
		return new IvParameterSpec(iv);
	}

	public static IvParameterSpec generateIv2() {
		byte[] iv = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		return new IvParameterSpec(iv);
	}

	public String encrypt(String algorithm, String input, SecretKey key,
			IvParameterSpec iv) throws NoSuchPaddingException, NoSuchAlgorithmException,
	InvalidAlgorithmParameterException, InvalidKeyException,
	BadPaddingException, IllegalBlockSizeException {

		Cipher cipher = Cipher.getInstance(algorithm);
		SecretKeySpec secretKeySpec = new SecretKeySpec(key.getEncoded(), "AES");
		cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, iv);
		byte[] cipherText = cipher.doFinal(input.getBytes());
		return Base64.getEncoder()
				.encodeToString(cipherText);
	}

	public String decrypt(String algorithm, String cipherText, SecretKey key,
			IvParameterSpec iv) throws NoSuchPaddingException, NoSuchAlgorithmException,
	InvalidAlgorithmParameterException, InvalidKeyException,
	BadPaddingException, IllegalBlockSizeException {

		Cipher cipher = Cipher.getInstance(algorithm);
		SecretKeySpec secretKeySpec = new SecretKeySpec(key.getEncoded(), "AES");
		cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, iv);
		byte[] plainText = cipher.doFinal(Base64.getDecoder()
				.decode(cipherText));
		return new String(plainText);
	}

	public static void main(String[] args) throws RuntimeException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, InvalidAlgorithmParameterException, BadPaddingException, IllegalBlockSizeException, InvalidKeySpecException {
		String originalString = "jljj";

		SecretKey key = AesEncryption4.generateKey(256);
		IvParameterSpec ivParameterSpec = AesEncryption4.generateIv();
		String algorithm = "AES/CBC/PKCS5Padding";

		AesEncryption4 aesEncryptionDecryption = new AesEncryption4();
		String encryptedString = aesEncryptionDecryption.encrypt(algorithm, originalString, key, ivParameterSpec);
		String decryptedString = aesEncryptionDecryption.decrypt(algorithm, encryptedString, key, ivParameterSpec);

		System.out.println(originalString);
		System.out.println(encryptedString);
		System.out.println(decryptedString);
	}

}