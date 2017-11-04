package com.example.blockchain.chain.block;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * This class provides a proof of work system that allows
 * for an expensive generation number and cheap validation mechanism.
 *
 * More about it: https://en.wikipedia.org/wiki/Proof-of-work_system
 */
@Component
public final class ProofOfWork {

    private final SymmetricSignature signature;

    @Autowired
    public ProofOfWork(SymmetricSignature signature) {
        this.signature = signature;
    }

    /**
     * Implements a brute-force proof of work based on a previous proof.
     * @param lastProof
     * @return
     */
    public int process(int lastProof) {

        int proof = 0;
        while(!validProof(lastProof, proof)) {
            proof++;
        }
        return proof;

    }

    private boolean validProof(int lastProof, int proof) {
        String guess = String.format("%d%d", lastProof, proof);

        String signedProof = signature.sign(guess.getBytes());
        return "0000".equals(signedProof.substring(0, 4));
    }

}
