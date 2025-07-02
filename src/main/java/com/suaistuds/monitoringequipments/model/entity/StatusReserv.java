package com.suaistuds.monitoringequipments.model.entity;

import java.util.HashMap;
import java.util.Map;

public enum StatusReserv {
    PENDING("pending"), CONFIRMED("confirmed"), CANCELLED("cancelled");

    private final String statusres;

    StatusReserv(String status) {
        this.statusres = status;
    }

    @Override
    public String toString() {
        return "\"" + this.name() + "\"";
    }

    private static final Map<String, StatusReserv> map = new HashMap<>();
    static {
        for (StatusReserv status : values()) {
            map.put(status.toString(), status);
        }
    }

    public static StatusReserv parse(String s) {
        StatusReserv result = map.get(s);
        if (result == null) {
            throw new IllegalArgumentException("Invalid reservation status: " + s);
        }
        return result;
    }
}
