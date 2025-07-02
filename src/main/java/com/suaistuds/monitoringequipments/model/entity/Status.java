package com.suaistuds.monitoringequipments.model.entity;

import java.util.HashMap;
import java.util.Map;

public enum Status {
    AVAILABLE("available"), RESERVED("reserved"), ISSUED("issued"), MAINTENANCE("maintenance"), DECOMMISSIONED("decommissioned");
    private final String status;
    Status(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "\"" + this.name() + "\"";
    }

    private static final Map<String, Status> map = new HashMap<>();
    static {
        for (Status status : values()) {
            map.put(status.toString(), status);
        }
    }

    public static Status parse(String s) {
        Status result = map.get(s);
        if (result == null) {
            throw new IllegalArgumentException("Invalid status: " + s);
        }
        return result;
    }
}
