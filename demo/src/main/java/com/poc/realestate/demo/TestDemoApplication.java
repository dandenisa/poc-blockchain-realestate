package com.poc.realestate.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.request.Transaction;
import org.web3j.protocol.core.methods.response.EthCoinbase;
import org.web3j.protocol.core.methods.response.EthGetTransactionCount;
import rx.Subscription;

import javax.annotation.PostConstruct;
import java.io.IOException;

import static java.math.BigInteger.valueOf;
import static org.web3j.protocol.core.DefaultBlockParameterName.LATEST;


@SpringBootApplication
public class TestDemoApplication {
    private static final Logger log = LoggerFactory.getLogger(TestDemoApplication.class.getName());
    @Autowired
    Web3j web3j;

    public static void main(String[] args) {
        log.info("Starting app.....");

        SpringApplication.run(TestDemoApplication.class, args);
    }

    @PostConstruct
    public void listen() {
        Subscription subscription = web3j.transactionObservable().subscribe(tx -> {
            log.info("New tx: id={}, block={}, from={}, to={}, value={}", tx.getHash(), tx.getBlockHash(), tx.getFrom(), tx.getTo(), tx.getValue().intValue());
            try {
                EthCoinbase coinbase = web3j.ethCoinbase().send();
                EthGetTransactionCount transactionCount = web3j.ethGetTransactionCount(tx.getFrom(), LATEST).send();
                log.info("Tx count: {}", transactionCount.getTransactionCount().intValue());
                if (transactionCount.getTransactionCount().intValue() % 10 == 0) {
                    EthGetTransactionCount tc = web3j.ethGetTransactionCount(coinbase.getAddress(), LATEST).send();
                    Transaction transaction = Transaction.createEtherTransaction(coinbase.getAddress(), tc.getTransactionCount(), tx.getValue(), valueOf(21_000), tx.getFrom(), tx.getValue());
                    web3j.ethSendTransaction(transaction).send();
                }
            } catch (IOException e) {
                log.error("Error getting transactions", e);
            }
        });
        log.info("Subscribed");
    }
}
