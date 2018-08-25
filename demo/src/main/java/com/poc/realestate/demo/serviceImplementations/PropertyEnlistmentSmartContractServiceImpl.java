package com.poc.realestate.demo.serviceImplementations;

import com.poc.realestate.demo.ethereum.EnlistmentToContract;
import com.poc.realestate.demo.serviceInterfaces.PropertyEnlistmentSmartContractService;
import com.poc.realestate.demo.tos.OfferTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.admin.Admin;
import org.web3j.protocol.admin.methods.response.PersonalUnlockAccount;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tuples.generated.Tuple5;

import java.io.IOException;
import java.math.BigInteger;
import java.util.NoSuchElementException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static java.math.BigInteger.TEN;
import static java.math.BigInteger.valueOf;
import static org.web3j.tx.Contract.GAS_LIMIT;
import static org.web3j.tx.ManagedTransaction.GAS_PRICE;

@Service(value = "contractService")
public class PropertyEnlistmentSmartContractServiceImpl implements PropertyEnlistmentSmartContractService {

    private static final String GANACHE_URL = "HTTP://127.0.0.1:7545";
    private static final String ACCOUNT_0 = "0x37B5C96002E2DAA3DFB0Da8c0e5B7fE3eB6051fa";
    private static final String ACCOUNT_0_PASSPHRASE = "42a205cd4599e58f10cb9b63b720ca8204f95a6a7ae824fef93a35807449ee5a";
    private static final String CONTRACT_ADDRESS_1 = "0x21E9a55D5D2F4ec6Aa644d8b7E3A3D99fCf1E606";
    private static final Logger log = LoggerFactory.getLogger(PropertyEnlistmentSmartContractServiceImpl.class.getName());

    public String getContractAddress1() {

        Admin web3j = Admin.build(new HttpService(GANACHE_URL));
        PersonalUnlockAccount personalUnlockAccount;
        EnlistmentToContract contract = null;
        try {
            personalUnlockAccount = web3j.personalUnlockAccount(ACCOUNT_0, "").send();

            if (personalUnlockAccount.accountUnlocked()) {
                Credentials credentials = getCredentials();
                contract = EnlistmentToContract.load(CONTRACT_ADDRESS_1, web3j, credentials, GAS_PRICE, GAS_LIMIT);

            }
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        if (contract != null) {
            return contract.getContractAddress();
        } else throw new NoSuchElementException("Could not retrieve contract.");
    }

    public void deploySmartContract() {

        Admin web3j = Admin.build(new HttpService(GANACHE_URL));
        PersonalUnlockAccount personalUnlockAccount;
        EnlistmentToContract contract = null;

        try {
            personalUnlockAccount = web3j.personalUnlockAccount(ACCOUNT_0, "").send();
            if (personalUnlockAccount.accountUnlocked()) {
                Credentials credentials = getCredentials();
                CompletableFuture<EnlistmentToContract> deploy = EnlistmentToContract.deploy(web3j, credentials,
                        GAS_PRICE,
                        GAS_LIMIT,
                        "denisa@d.d",
                        "identifierD",
                        "denisa name",
                        "denisaaddress",
                        "details").sendAsync();

            }
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    private Credentials getCredentials() {
        return Credentials.create(ACCOUNT_0_PASSPHRASE);
    }

    @Override
    @Transactional
    public String sendOfferToSmartContract(String contractAddress, OfferTO offer) {
        Admin web3j = Admin.build(new HttpService(GANACHE_URL));
        PersonalUnlockAccount personalUnlockAccount;
        EnlistmentToContract contract = null;
        CompletableFuture<TransactionReceipt> sendOfferTx = null;

        try {
            personalUnlockAccount = web3j.personalUnlockAccount(ACCOUNT_0, "").send();

            if (personalUnlockAccount.accountUnlocked()) {
                Credentials credentials = getCredentials();
                contract = EnlistmentToContract.load(contractAddress, web3j, credentials, GAS_PRICE, valueOf(3000000));
                sendOfferTx = contract.sendOffer(offer.getAmount(), offer.getTenantName(), offer.getTenantEmail(), TEN).sendAsync();
            }
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        try {
            return sendOfferTx.get().getTransactionHash();
        } catch (InterruptedException | ExecutionException e) {
            log.error(e.getMessage());
            throw new NoSuchElementException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public OfferTO getOfferFromSmartContract(String contractAddress, String tenantEmail) {
        Admin web3j = Admin.build(new HttpService(GANACHE_URL));
        PersonalUnlockAccount personalUnlockAccount;
        EnlistmentToContract contract = null;
        OfferTO offer = null;

        try {
            personalUnlockAccount = web3j.personalUnlockAccount(ACCOUNT_0, "").send();

            if (personalUnlockAccount.accountUnlocked()) {
                Credentials credentials = getCredentials();
                contract = EnlistmentToContract.load(CONTRACT_ADDRESS_1, web3j, credentials, GAS_PRICE, valueOf(3000000));
                Tuple5<Boolean, BigInteger, String, String, BigInteger> offerResponse = contract.getOffer(tenantEmail).sendAsync().get();
                offer = new OfferTO(offerResponse.getValue1(),
                        offerResponse.getValue2(),
                        offerResponse.getValue3(),
                        offerResponse.getValue4(),
                        offerResponse.getValue5());
            }
        } catch (IOException | InterruptedException | ExecutionException e) {
            log.error(e.getMessage());
        }
        return offer;
    }

    @Override
    public String reviewOfferFromSmartContract(String contractAddress, String tenantEmail, boolean approved) {
        Admin web3j = Admin.build(new HttpService(GANACHE_URL));
        PersonalUnlockAccount personalUnlockAccount;
        EnlistmentToContract contract;
        TransactionReceipt transactionReceipt = null;

        try {
            personalUnlockAccount = web3j.personalUnlockAccount(ACCOUNT_0, "").send();

            if (personalUnlockAccount.accountUnlocked()) {
                Credentials credentials = getCredentials();
                contract = EnlistmentToContract.load(CONTRACT_ADDRESS_1, web3j, credentials, GAS_PRICE, valueOf(3000000));
                transactionReceipt = contract.reviewOffer(approved, tenantEmail, TEN).sendAsync().get();

            }
        } catch (IOException | InterruptedException | ExecutionException e) {
            log.error(e.getMessage());
        }
        return transactionReceipt.getTransactionHash();
    }
}

