package com.abigail221b.dentalClinic_backend.Appointment;

import java.sql.Date;
import java.time.LocalTime;

import lombok.Data;

@Data
public class AppointmentIdDTO {

    private int patientId;
    private Date date;
    private LocalTime startTime;
    
}
