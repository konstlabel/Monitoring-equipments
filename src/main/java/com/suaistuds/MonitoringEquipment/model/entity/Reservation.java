package com.suaistuds.MonitoringEquipment.model.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDateTime;

@Data
@Builder
public class Reservation {
    @NonNull
    private Long id;
    @NonNull
    private Equipment equipment;
    @NonNull
    private User user;
    @NonNull
    private LocalDateTime startTime;
    @NonNull
    private LocalDateTime endTime;
    @NonNull
    private Status status;
}
