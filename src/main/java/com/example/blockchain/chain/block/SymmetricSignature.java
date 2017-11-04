package com.example.blockchain.chain.block;

import org.springframework.stereotype.Component;

import java.security.MessageDigest;

/**
 * Class responsible for SHA-256 signature.
 */
@Component
public class SymmetricSignature {

    public String sign(byte[] content) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] signed = digest.digest(content);

            StringBuilder result = new StringBuilder();
            for (byte b : signed) {
                result.append(String.format("%02x", b));
            }
            return result.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
