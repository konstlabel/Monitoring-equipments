package com.suaistuds.monitoringequipments.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Equipment {
    @NotNull
    private @Id Long ID;
    @NotNull
    private String Name;
    @NotNull
    private String SerialNumber;
    @NotNull
    private Status Status;
    @NotNull
    private String Type;
}