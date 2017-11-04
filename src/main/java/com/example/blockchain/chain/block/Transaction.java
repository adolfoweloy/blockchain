package com.example.blockchain.chain.block;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Just a data structure to represent a single transaction.
 */
@AllArgsConstructor
public class Transaction {
    @Getter
    private String sender;
    @Getter
    private String recipient;
    @Getter
    private int amount;
}
