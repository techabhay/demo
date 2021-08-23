package com.example.demo.utils;

import java.nio.charset.Charset;
import java.security.Key;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AesEncryption2 {

    private static final String CHARSET = "UTF-8";
    private Key aesKey;

    public AesEncryption2(String key) {
        aesKey = new SecretKeySpec(key.getBytes(Charset.forName(CHARSET)), "AES");
    }

   public String decrypt(String strToDecrypt) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, aesKey);
            return new String(cipher.doFinal(
                    Base64.getDecoder().decode(strToDecrypt)), Charset.forName(CHARSET));
        } catch (Exception e) {
           e.printStackTrace();
           throw new RuntimeException();
        }

    }

    public String encrypt(String strToEncrypt) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
            return Base64.getEncoder().encodeToString(
                    cipher.doFinal(strToEncrypt.getBytes(Charset.forName(CHARSET))));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }

    }
    public static void main(String[] args) {
        final String secretKey = "secreteaeisyairr";

        String originalString = "jljj";

        AesEncryption2 aesEncryptionDecryption = new AesEncryption2(secretKey);
        String encryptedString = aesEncryptionDecryption.encrypt(originalString);
        String decryptedString = aesEncryptionDecryption.decrypt(encryptedString);

        System.out.println(originalString);
        System.out.println(encryptedString);
        System.out.println(decryptedString);
    }

}