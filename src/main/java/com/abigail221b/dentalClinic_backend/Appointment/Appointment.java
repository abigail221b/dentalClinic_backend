package com.abigail221b.dentalClinic_backend.Appointment;

import java.time.LocalDate;
import java.time.LocalTime;

import com.abigail221b.dentalClinic_backend.Dentist.Dentist;
import com.abigail221b.dentalClinic_backend.Patient.Patient;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Appointment {

    @ManyToOne
    @JoinColumn(
        name = "appointment_patient",
        referencedColumnName = "id"
    )
    private Patient patient;

    private LocalDate date;

    private LocalTime startTime;

    @ManyToOne
    @JoinColumn(
        name = "appointment_dentist",
        referencedColumnName = "id"
    )
    private Dentist dentist;

    private int duration;

}
