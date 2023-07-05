package com.hostfully.model;

public enum BlockStatus {
    ACTIVE("ACTIVE"),
    CANCELLED ("CANCELLED");

    public final String status;

    private BlockStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
