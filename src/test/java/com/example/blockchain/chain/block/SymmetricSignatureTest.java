package com.example.blockchain.chain.block;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SymmetricSignatureTest {

    @Test
    public void shouldSignContentWithSHA256() {
        SymmetricSignature subject = new SymmetricSignature();
        String hex = subject.sign("80".getBytes());
        assertEquals("48449a14a4ff7d79bb7a1b6f3d488eba397c36ef25634c111b49baf362511afc", hex);
    }
}