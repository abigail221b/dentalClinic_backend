package com.abigail221b.dentalClinic_backend.Appointment;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class AppointmentId {
    
    private int patientId;
    private Date date;
    private Time startTime;

}
