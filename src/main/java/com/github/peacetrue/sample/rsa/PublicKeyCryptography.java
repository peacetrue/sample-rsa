package com.github.peacetrue.sample.rsa;

/**
 * 公开密钥加密（非对称加密）
 *
 * @author : xiayx
 * @since : 2021-08-08 15:33
 **/
public interface PublicKeyCryptography<PublicKey, PrivateKey> {

    /**
     * 生成密钥对。[0]：公钥、[1]：私钥
     */
    KeyPair<PublicKey, PrivateKey> generateKeyPair(int length);

    /**
     * 使用公钥加密
     */
    byte[] encrypt(byte[] message, PublicKey publicKey);

    /**
     * 使用私钥解密
     */
    byte[] decrypt(byte[] message, PrivateKey privateKey);

}
