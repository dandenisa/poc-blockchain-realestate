package com.poc.realestate.demo.model;

public class TestBlockchainTransaction {

    private int fromId;
    private int toId;
    private long value;

    public TestBlockchainTransaction(int fromId, int toId, long value) {
        this.fromId = fromId;
        this.toId = toId;
        this.value = value;
    }

    public TestBlockchainTransaction() {


    }

    public int getFromId() {
        return fromId;
    }

    public void setFromId(int fromId) {
        this.fromId = fromId;
    }

    public int getToId() {
        return toId;
    }

    public void setToId(int toId) {
        this.toId = toId;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

}

