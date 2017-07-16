package com.fitness.constant;

/**
 * Created on 2017/7/3.
 */
public class Constant {

    public static final String URL_KEEPER="http://localhost:8088";

    /**
     * PBK加密算法
     */
    public static final String PBKDF2_ALGORITHM = "PBKDF2WithHmacSHA1";

    /**
     * Oath加密算法
     */
    public static final String OATH_ALGORITHM = "AES/ECB/PKCS5Padding";

    /**
     * Oath逆向秘钥
     */
    public static final String OATH_KEY = "LEKWRVOUHAYCSQCR";

    /**
     * 盐的长度
     */
    public static final int SALT_BYTE_SIZE = 40 / 2;

    /**
     * 生成密文的长度
     */
    public static final int HASH_BIT_SIZE = 128 * 2;

    /**
     * 迭代次数
     */
    public static final int PBKDF2_ITERATORS = 500;

    /**
     * 固定盐
     */
    public static final String ENCRYPT_SALT = "ed1936ff13f5c5776dc39a2503044af99b02b369";

    /**
     * 默认密码
     */
    public static final String DEFAULT_PASSWORD = "888888";

    /**
     * redis记录在线用户使用key
     */
    public static final String ON_LINE = "on_line:";

    /**
     * 图片相对路径
     */
    public static final String PATH="/home/img/";

}
