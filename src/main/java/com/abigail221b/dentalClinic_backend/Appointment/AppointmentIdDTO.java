package com.abigail221b.dentalClinic_backend.Appointment;

import java.sql.Date;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentIdDTO {

    private int patientId;
    private Date date;
    private LocalTime startTime;
    
}
