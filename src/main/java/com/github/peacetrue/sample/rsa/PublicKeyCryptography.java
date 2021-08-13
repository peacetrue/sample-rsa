package com.github.peacetrue.sample.rsa;

/**
 * 公开密钥加密（非对称加密）
 *
 * @author : xiayx
 * @since : 2021-08-08 15:33
 **/
public interface PublicKeyCryptography {

    /** 生成密钥对。[0]：公钥、[1]：私钥 */
    int[] generateKeyPair();

    /** 使用公钥加密 */
    int encode(int message, int publicKey);

    /** 使用私钥解密 */
    int decode(int message, int privateKey);

}
