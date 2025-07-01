pom.xml
src/
└── main/
│   └── java/
│   │   └── com/
│   │       └── suaistuds/
│   │           └── MonitoringEquipment/
│   │               ├── MonitoringEquipmentApplication.java
│   │               ├── config/
│   │               │   ├── WebConfig.java
│   │               │   ├── OpenApiConfig.java
│   │               │   └── MaintenanceScheduler.java
│   │               ├── security/
│   │               │   ├── JwtUtil.java
│   │               │   ├── SecurityConfig.java
│   │               │   ├── JwtRequestFilter.java
│   │               │   └── CustomUserDetailsService.java
│   │               ├── model/
│   │               │   ├── dto/
│   │               │   │   ├── AuthRequestDto.java
│   │               │   │   ├── AuthResponseDto.java
│   │               │   │   ├── EquipmentDto.java
│   │               │   │   ├── ReservationDto.java
│   │               │   │   ├── ReserveRequestDto.java
│   │               │   │   ├── IssueDto.java
│   │               │   │   ├── ReturnDto.java
│   │               │   │   ├── MaintenanceDto.java
│   │               │   │   └── UsageDto.java
│   │               │   └── entity/
│   │               │       ├── User.java
│   │               │       ├── Equipment.java
│   │               │       ├── Reservation.java
│   │               │       ├── StatusHistory.java
│   │               │       ├── MaintenanceTask.java
│   │               │       └── (при необходимости другие Enum’ы)
│   │               ├── repository/
│   │               │   ├── UserRepository.java
│   │               │   ├── EquipmentRepository.java
│   │               │   ├── ReservationRepository.java
│   │               │   ├── StatusHistoryRepository.java
│   │               │   └── MaintenanceRepository.java
│   │               ├── service/
│   │               │   ├── UserService.java
│   │               │   ├── EquipmentService.java
│   │               │   ├── ReservationService.java
│   │               │   ├── HistoryService.java
│   │               │   ├── MaintenanceService.java
│   │               │   └── StatsService.java
│   │               │   └── impl/
│   │               │       ├── UserServiceImpl.java
│   │               │       ├── EquipmentServiceImpl.java
│   │               │       ├── ReservationServiceImpl.java
│   │               │       ├── HistoryServiceImpl.java
│   │               │       ├── MaintenanceServiceImpl.java
│   │               │       └── StatsServiceImpl.java
│   │               ├── controller/
│   │               │   ├── AuthController.java
│   │               │   ├── EquipmentController.java
│   │               │   ├── ReservationController.java
│   │               │   └── StatsController.java
│   │               └── util/
│   │                   └── qrCodeUtil.java
│   │
│   └── resourses/
│       └── application.yaml
│
└── test/
    └── java/
        └── com/
            └── suaistuds/
                └── MonitoringEquipment/
                    └── MonitoringEquipmentApplicationTest.java
