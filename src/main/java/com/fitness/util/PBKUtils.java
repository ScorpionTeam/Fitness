package com.fitness.util;

import com.fitness.constant.Constant;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

/**
 * Created by kunlun on 2017/4/27.
 */
public class PBKUtils {

    public static String getEncryptedPassword(String password, String salt) throws NoSuchAlgorithmException, InvalidKeySpecException {
        KeySpec spec = new PBEKeySpec(password.toCharArray(), fromHex(salt), Constant.PBKDF2_ITERATORS,
                Constant.HASH_BIT_SIZE);
        SecretKeyFactory factory = SecretKeyFactory.getInstance(Constant.PBKDF2_ALGORITHM);
        return toHex(factory.generateSecret(spec).getEncoded());
    }

    /**
     * 十六进制字符串  转二进制字符串
     *
     * @param hex
     * @return
     */
    private static byte[] fromHex(String hex) {
        byte[] binary = new byte[hex.length() / 2];
        for (int i = 0; i < binary.length; i++) {
            binary[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
        }
        return binary;
    }

    /**
     * 通过提供加密的强随机数生成器   生成盐
     *
     * @return
     */
    public static String generateSalt() throws NoSuchAlgorithmException {
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[Constant.SALT_BYTE_SIZE];
        random.nextBytes(salt);
        return toHex(salt);
    }

    /**
     * 二进制字符串转十六进制字符串
     *
     * @param array
     * @return
     */
    private static String toHex(byte[] array) {
        BigInteger bi = new BigInteger(1, array);
        String hex = bi.toString(16);
        int paddingLength = (array.length * 2) - hex.length();
        if (paddingLength > 0)
            return String.format("%0" + paddingLength + "d", 0) + hex;
        else
            return hex;
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException {
        String salt = PBKUtils.generateSalt();
        String password = "888888";
        String encryptPassword = PBKUtils.getEncryptedPassword(password,Constant.ENCRYPT_SALT);
        System.out.println("随机盐："+salt);
        System.out.println("密文："+encryptPassword);
    }
}
