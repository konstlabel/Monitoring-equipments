package com.suaistuds.monitoringequipments.model.entity;

import java.util.HashMap;
import java.util.Map;

public enum Role {
    User("User"),Admin("Admin");
    private final String role;

    Role(String role) {
        this.role = role;
    }
    @Override
    public String toString() {
        return "\"" + role + "\"";
    }
    private static final Map<String, Role> map = new HashMap<>();
    static {
        for (Role role : values()) {
            map.put(role.toString(), role);
        }
    }
    public static Role parse(String s) {
        Role result = map.get(s);
        if (result == null) {
            throw new IllegalArgumentException("Invalid category: " + s);
        }
        return result;
    }
}

