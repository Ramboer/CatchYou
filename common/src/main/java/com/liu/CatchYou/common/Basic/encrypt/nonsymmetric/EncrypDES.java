package com.liu.CatchYou.common.Basic.encrypt.nonsymmetric;

import com.sun.crypto.provider.SunJCE;

import javax.crypto.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

/**
 * Created by simon.liu on 2017/9/18.
 */
public class EncrypDES {
    private KeyGenerator keyGenerator;
    private SecretKey secretKey;
    private Cipher cipher;
    private byte[] cihperBytes;

    /**
     * construct
     */
    public EncrypDES() throws NoSuchAlgorithmException, NoSuchPaddingException {
        Security.addProvider(new SunJCE());
        keyGenerator = KeyGenerator.getInstance("DES");
        secretKey = keyGenerator.generateKey();
        cipher = Cipher.getInstance("DES");
    }

    /**
     * encrypt
     * @param str
     * @return
     * @throws InvalidKeyException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     */
    public byte[] encrytor(String str) throws InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] bytes = str.getBytes();
        cihperBytes = cipher.doFinal(bytes);
        return cihperBytes;
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
        byte[] bytes = cipher.doFinal(buff);
        return bytes;
    }

    public static void main(String[] args) {
        try {
            EncrypDES encrypDES = new EncrypDES();
            String str = "Jia Xin";
            byte[] en = encrypDES.encrytor(str);
            byte[] de = encrypDES.decryptor(en);
            System.out.println("明文： " + str);
            System.out.println("加密后：　" + new String(en));
            System.out.println("加密后：　" + new String(de));

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
    }
}
