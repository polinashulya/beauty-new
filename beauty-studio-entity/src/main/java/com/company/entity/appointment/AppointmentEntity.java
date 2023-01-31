package com.company.entity.appointment;

import com.company.entity.ProcedureEntity;
import com.company.entity.user.UserEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class AppointmentEntity {

    private UserEntity client;

    private UserEntity master;

    private Set<ProcedureEntity> procedures = new HashSet<>();

    private LocalDateTime plannedStartTime;

    private LocalDateTime plannedEndTime;

    private AppointmentStatus status;

    private BigDecimal price;

    private LocationEntity location;

    private String clientComment;


    private LocalDateTime actualStartTime;

    private LocalDateTime actualEndTime;


    // private Set<AppointmentRecord> records = new HashSet<>();

}
