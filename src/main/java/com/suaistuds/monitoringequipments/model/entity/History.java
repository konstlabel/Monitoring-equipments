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
public class History {
    @NonNull
    private @Id Long ID;
    @NonNull
    private Long equipment;
    @NonNull
    private Long user;
    @NonNull
    private Long responsible;
    @NonNull
    private Status status;
    @NonNull
    private LocalDateTime date;
}
