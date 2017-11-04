package com.example.blockchain.chain.block;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Class in charge of hashing blocks.
 */
@Component
public class BlockHash {

    private final SymmetricSignature signature;

    @Autowired
    public BlockHash(SymmetricSignature signature) {
        this.signature = signature;
    }

    public String hash(Block block) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            byte[] binaryJson = mapper.writer()
                    .forType(Block.class)
                    .writeValueAsBytes(block);

            return signature.sign(binaryJson);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
