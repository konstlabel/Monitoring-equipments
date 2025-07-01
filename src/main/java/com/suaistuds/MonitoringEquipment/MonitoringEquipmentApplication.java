package com.suaistuds.MonitoringEquipment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.r2dbc.R2dbcAutoConfiguration;

@SpringBootApplication(exclude = {R2dbcAutoConfiguration.class})
public class MonitoringEquipmentApplication {
	public static void main(String[] args) {
		SpringApplication.run(MonitoringEquipmentApplication.class, args);
	}
}
