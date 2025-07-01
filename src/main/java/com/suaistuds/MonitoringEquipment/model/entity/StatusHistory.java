package com.suaistuds.MonitoringEquipment.model.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDate;

@Data
@Builder
public class StatusHistory {
    @NonNull
    private Long id;
    @NonNull
    private Equipment equipment;
    @NonNull
    private Status oldStatus;
    @NonNull
    private LocalDate timestamp;
    @NonNull
    private User changedByUser;
}
