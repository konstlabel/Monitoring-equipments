package com.suaistuds.MonitoringEquipment.model.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDate;

@Data
@Builder
public class MaintenanceTask {
    @NonNull
    private Long id;
    @NonNull
    private Equipment equipment;
    @NonNull
    private LocalDate scheduledDate;
    @NonNull
    private LocalDate completedDate;
    @NonNull
    private Status status;
}
