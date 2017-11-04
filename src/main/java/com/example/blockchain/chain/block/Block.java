package com.example.blockchain.chain.block;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@EqualsAndHashCode
public class Block {

    @Getter
    private int index;

    @Getter
    private long timestamp;

    @Getter
    private List<Transaction> transactions = new ArrayList<>();

    @Getter
    private int proof;

    @Getter
    private String previousHash;

    private Block() {}

    /**
     * generates the block that should be the first on a given chain
     * @return
     */
    public static Block genesis() {
        Block block = new Block();
        block.index = 1;
        block.transactions = new ArrayList<>();
        block.previousHash = "1";
        block.proof = 100;
        block.timestamp = new Date().getTime();
        return block;
    }

    /**
     * Generates a new block (WIP)
     *
     * @param previousBlock
     * @param transactions
     * @param proof
     * @param previousHash
     * @return
     */
    public static Block newBlock(Block previousBlock, List<Transaction> transactions, int proof, String previousHash) {
        int index = previousBlock.getIndex() + 1;
        long timestamp = new Date().getTime();

        Block block = new Block();
        block.index = index;
        block.timestamp = timestamp;
        block.transactions = transactions;
        block.proof = proof;
        block.previousHash = previousHash;

        return block;
    }

}
