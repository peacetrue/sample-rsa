package com.github.peacetrue.sample.rsa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.crypto.Cipher;
import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

/**
 * @author : xiayx
 * @since : 2021-08-13 12:44
 **/
class JDKRSATest {

    @Test
    void basic() throws Exception {
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(1024, new SecureRandom());
        KeyPair keyPair = generator.generateKeyPair();
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();  // 得到公钥
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();   // 得到私钥

        String message = "peacetrue";
        byte[] messageBytes = message.getBytes(StandardCharsets.UTF_8);
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] messageEncoded = cipher.doFinal(messageBytes);

        cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] messageDecodedBytes = cipher.doFinal(messageEncoded);
        String messageDecoded = new String(messageDecodedBytes, StandardCharsets.UTF_8);
        Assertions.assertEquals(message, messageDecoded);
    }
}
