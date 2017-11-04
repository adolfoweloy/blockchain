package com.example.blockchain.chain;

import com.example.blockchain.chain.block.Block;
import com.example.blockchain.chain.block.BlockHash;
import com.example.blockchain.chain.block.Transaction;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.example.blockchain.chain.block.Block.genesis;
import static com.example.blockchain.chain.block.Block.newBlock;

@Component
public class Blockchain implements InitializingBean {
    private final BlockHash mac;
    private final List<Block> chain;

    private List<Transaction> currentTransactions = new ArrayList<>();

    @Autowired
    public Blockchain(BlockHash blockHash) {
        this.mac = blockHash;
        this.chain = new ArrayList<>();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        chain.add(genesis());
    }

    public List<Block> chain() {
        return Collections.unmodifiableList(chain);
    }

    public Block block(int proof) {
        String previousHash = mac.hash(lastBlock());

        Block block = newBlock(lastBlock(), currentTransactions, proof, previousHash);
        currentTransactions = new ArrayList<>();
        chain.add(block);

        return block;
    }

    public int transaction(Transaction transaction) {
        currentTransactions.add(transaction);
        return lastBlock().getIndex();
    }

    public Block lastBlock() {
        return chain.get(chain.size() - 1);
    }

}
