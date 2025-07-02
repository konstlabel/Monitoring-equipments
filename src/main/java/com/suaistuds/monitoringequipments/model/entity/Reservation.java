package com.suaistuds.monitoringequipments.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Reservation {
    @NonNull
    private @Id Long ID;
    @NonNull
    private Long equipment;
    @NonNull
    private Long user;
    @NonNull
    private LocalDateTime startTime;
    @NonNull
    private LocalDateTime endTime;
    @NonNull
    private StatusReserv status;
}
