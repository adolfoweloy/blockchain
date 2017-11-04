package com.example.blockchain.chain.block;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProofOfWorkTest {

    @Test
    public void shouldFindAValidProof() {
        ProofOfWork proofOfWork = new ProofOfWork(new SymmetricSignature());
        int result = proofOfWork.proofOfWork(100);
        assertEquals(35293, result);
    }

}