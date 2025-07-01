package com.suaistuds.MonitoringEquipment.model.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
@Builder
public class User {
    @NonNull
    private final Long id;
    @NonNull
    private String login;
    @NonNull
    private String password;
    @NonNull
    private List<Role> roles;
    @NonNull
    private String email;


}
