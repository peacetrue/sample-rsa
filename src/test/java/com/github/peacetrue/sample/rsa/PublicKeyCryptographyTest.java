package com.github.peacetrue.sample.rsa;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

/**
 * @author : xiayx
 * @since : 2021-08-13 12:43
 **/
class PublicKeyCryptographyTest {

    @Test
    void jdk() {
        test(new JDKPublicKeyCryptography());
    }

    public <PublicKey, PrivateKey> void test(PublicKeyCryptography<PublicKey, PrivateKey> cryptography) {
        KeyPair<PublicKey, PrivateKey> keyPair = cryptography.generateKeyPair(1024);
        String message = RandomStringUtils.random(10);
        byte[] messageBytes = message.getBytes(StandardCharsets.UTF_8);
        byte[] encryptedMessageBytes = cryptography.encrypt(messageBytes, keyPair.getPublicKey());
        byte[] decryptMessageBytes = cryptography.decrypt(encryptedMessageBytes, keyPair.getPrivateKey());
        Assertions.assertArrayEquals(messageBytes, decryptMessageBytes);
    }
}
