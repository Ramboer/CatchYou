package com.liu.CatchYou.common.Basic.encrypt.nonsymmetric;

import com.sun.crypto.provider.SunJCE;

import javax.crypto.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

/**
 * Created by simon.liu on 2017/9/18.
 */
public class EncrypAES {
    private KeyGenerator keyGenerator;
    private SecretKey secretKey;
    private Cipher cipher;

    /**
     * construct
     * @throws NoSuchAlgorithmException
     * @throws NoSuchPaddingException
     */
    public EncrypAES() throws NoSuchAlgorithmException, NoSuchPaddingException {
         Security.addProvider(new SunJCE());
         keyGenerator = KeyGenerator.getInstance("AES");
         secretKey = keyGenerator.generateKey();
         cipher = Cipher.getInstance("AES");
    }

    /**
     * encrypt
     * @param str
     * @return
     * @throws InvalidKeyException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     */
    public byte[] encryptor(String str) throws InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] bytes = str.getBytes();
        return cipher.doFinal(bytes);
    }

    /**
     * decrypt
     * @param buff
     * @return
     * @throws InvalidKeyException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     */
    public byte[] decryptor(byte[] buff) throws InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        return cipher.doFinal(buff);
    }

    /**
     * main
     * @param args
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     * @throws BadPaddingException
     * @throws InvalidKeyException
     * @throws IllegalBlockSizeException
     */
    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, IllegalBlockSizeException {
        EncrypAES encrypAES = new EncrypAES();
        String str = "Jia Xin";
        byte[] enRes = encrypAES.encryptor(str);
        byte[] deRes = encrypAES.decryptor(enRes);
        System.out.println("明文： " + str);
        System.out.println("加密后： " + new String(enRes));
        System.out.println("解密后： " + new String(deRes));
    }

}
