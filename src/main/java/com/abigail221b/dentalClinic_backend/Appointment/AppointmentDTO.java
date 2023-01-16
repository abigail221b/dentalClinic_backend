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
    private AppointmentPatientDTO patient;
    private LocalDate date;
    private LocalTime startTime;
    private AppointmentDentistDTO dentist;
    private int duration;

}
