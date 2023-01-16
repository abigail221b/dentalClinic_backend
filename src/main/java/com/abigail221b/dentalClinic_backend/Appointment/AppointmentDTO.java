package com.abigail221b.dentalClinic_backend.Appointment;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDTO {

    private int id;
    private int patientId;
    private String patientFirstName;
    private String patientLastName;
    private LocalDate date;
    private LocalTime startTime;
    private int dentistId;
    private String dentistFirstName;
    private String dentistLastName;
    private int duration;

}
