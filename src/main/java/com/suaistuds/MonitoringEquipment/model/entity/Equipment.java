package com.suaistuds.MonitoringEquipment.model.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class Equipment {
    @NonNull
    private Long id;
    @NonNull
    private TypeEquipment type;
    @NonNull
    private Status status;

    private Long qrCodeValue;

}
