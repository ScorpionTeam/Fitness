package com.fitness.util;


import com.fitness.constant.Constant;
import sun.misc.BASE64Decoder;
import org.apache.commons.codec.binary.Base64;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created on 2017/7/12.
 */
public class OathUtil {



    public static String base64Encode(byte[] bytes) {
        return Base64.encodeBase64String(bytes);
    }




    public static byte[] base64Decode(String base64Code) throws Exception {
        return new BASE64Decoder().decodeBuffer(base64Code);
    }




    public static byte[] aesEncryptToBytes(String content, String encryptKey) throws Exception {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        kgen.init(128);
        Cipher cipher = Cipher.getInstance(Constant.OATH_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(encryptKey.getBytes(), "AES"));

        return cipher.doFinal(content.getBytes("utf-8"));
    }




    public static String aesEncrypt(String content, String encryptKey) throws Exception {
        return base64Encode(aesEncryptToBytes(content, encryptKey));
    }



    public static String aesDecryptByBytes(byte[] encryptBytes, String decryptKey) throws Exception {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        kgen.init(128);

        Cipher cipher = Cipher.getInstance(Constant.OATH_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(decryptKey.getBytes(), "AES"));
        byte[] decryptBytes = cipher.doFinal(encryptBytes);

        return new String(decryptBytes);
    }



    public static String aesDecrypt(String encryptStr, String decryptKey) throws Exception {
        return aesDecryptByBytes(base64Decode(encryptStr), decryptKey);
    }



    public static void main(String[] args) throws Exception {
        String content = "admin123456";
        System.out.println("加密");
        String encrypt = OathUtil.aesEncrypt(content, Constant.OATH_KEY);
        System.out.println(encrypt);
        System.out.println("解密");
        System.out.println(OathUtil.aesDecrypt(encrypt, Constant.OATH_KEY));
    }
}
