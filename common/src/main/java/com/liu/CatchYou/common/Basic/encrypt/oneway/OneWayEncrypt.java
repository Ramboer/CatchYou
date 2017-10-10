package com.liu.CatchYou.common.Basic.encrypt.oneway;


import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by simon.liu on 2017/9/20.
 */
public class OneWayEncrypt {
    private static final String KEY_MD5 = "MD5";
    private static final String KEY_SHA = "SHA";
    private static final String KEY_MAC = "hmacMD5";

    /**
     * BASE 64 encrypt
     * @param bytes bytes to encrypt
     * @return
     */
    public static String encrypBASE64(byte[] bytes) {
        return (new BASE64Encoder()).encodeBuffer(bytes);
    }

    /**
     * BASE 64 decrypt
     * @param str string to decrypt
     * @return
     * @throws IOException IO exception
     */
    public static byte[] decrypBASE64(String str) throws IOException {
        return (new BASE64Decoder()).decodeBuffer(str);
    }

    /**
     * MD5 encrypt
     * @param bytes bytes to encrypt
     * @return
     * @throws NoSuchAlgorithmException no such algorithm exception
     */
    public static byte[] encryptMD5(byte[] bytes) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance(KEY_MD5);
        md5.update(bytes);
        return md5.digest();
    }

    /**
     * SHA encrypt
     * @param bytes bytes to encrypt
     * @return
     * @throws NoSuchAlgorithmException no such algorithm exception
     */
    public static byte[] encryptSHA(byte[] bytes) throws NoSuchAlgorithmException {
        MessageDigest sha = MessageDigest.getInstance(KEY_SHA);
        sha.update(bytes);
        return sha.digest();
    }

    /**
     * init mac key
     * @return
     * @throws NoSuchAlgorithmException no such algorithm exception
     */
    public static String initMacKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(KEY_MAC);
        SecretKey secretKey = keyGenerator.generateKey();
        return encrypBASE64(secretKey.getEncoded());
    }

    /**
     *
     * @param bytes bytes to encrpyt
     * @param key mac key
     * @return
     * @throws IOException IO exception
     * @throws NoSuchAlgorithmException no such algorithm exception
     * @throws InvalidKeyException invalid key exception
     */
    public static byte[] encryptHMAC(byte[] bytes, String key) throws IOException, NoSuchAlgorithmException, InvalidKeyException {
        SecretKey secretKey = new SecretKeySpec(decrypBASE64(key), KEY_MAC);
        Mac mac = Mac.getInstance(secretKey.getAlgorithm());
        mac.init(secretKey);
        return mac.doFinal(bytes);
    }

    /**
     * main
     * @param args params before run input
     * @throws NoSuchAlgorithmException no such algorithm exception
     * @throws IOException IO exception
     * @throws InvalidKeyException invalid key exception
     */
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException, InvalidKeyException {
        String inputStr = "Jia Xin";
        System.out.println("原文: " + inputStr);
        System.out.print("BASE64加密: " + encrypBASE64(inputStr.getBytes()));
        System.out.println("MD5加密: " + new String(encryptMD5(inputStr.getBytes())));
        System.out.println("SHA加密: " + new String(encryptSHA(inputStr.getBytes())));
        System.out.println("HMAC加密: " + new String(encryptHMAC(inputStr.getBytes(), initMacKey())));
    }
}
