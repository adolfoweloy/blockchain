package com.example.blockchain.web;

import com.example.blockchain.chain.block.Block;
import com.example.blockchain.chain.Blockchain;
import com.example.blockchain.chain.block.ProofOfWork;
import com.example.blockchain.chain.block.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class BlockchainController {

    @Autowired
    private Blockchain blockchain;

    @Autowired
    private ProofOfWork proofOfWork;

    @PostMapping("/transaction")
    public ResponseEntity<String> addTransaction(@RequestBody Transaction transaction) {
        int index = blockchain.transaction(transaction);
        return ResponseEntity.status(201).body("Transaction will be added to block: " + (index + 1));
    }

    @GetMapping("/chain")
    public ResponseEntity<List<Block>> chain() {
        return ResponseEntity.ok(blockchain.chain());
    }

    @PostMapping("/mine")
    public ResponseEntity<Block> mine() {
        Block lastBlock = blockchain.lastBlock();
        int lastProof = lastBlock.getProof();
        int proof = proofOfWork.proofOfWork(lastProof);

        Transaction transaction = new Transaction("0", "node1", 1);
        blockchain.transaction(transaction);

        Block block = blockchain.block(proof);

        return ResponseEntity.status(201).body(block);
    }

}
