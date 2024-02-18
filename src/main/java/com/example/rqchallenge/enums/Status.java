package com.example.rqchallenge.enums;

public enum Status {
    SUCCESS("success"),FAILURE("failed");
    private final String status;

    private Status(String status) {
        this.status = status;
    }

    public String getStatus(){
        return status;
    }
}
