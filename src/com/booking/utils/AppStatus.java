package com.booking.utils;


public enum AppStatus {
    REJECTED,
    APPROVED,
    EXPECTATION,
    UNKNOWN;

    public AppStatus getStatusByName(String status) {
        try {
            return AppStatus.valueOf(status);
        } catch (IllegalArgumentException exception) {
            return UNKNOWN;
        }
    }
}

