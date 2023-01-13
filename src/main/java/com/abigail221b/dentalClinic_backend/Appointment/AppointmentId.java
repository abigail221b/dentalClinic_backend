package com.abigail221b.dentalClinic_backend.Appointment;

import java.time.LocalDate;
import java.time.LocalTime;

import com.abigail221b.dentalClinic_backend.Patient.Patient;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class AppointmentId {

    @ManyToOne
    @JoinColumn(
        name = "appointment_patient",
        referencedColumnName = "id"
    )
    private Patient patient;

    private LocalDate date;

    private LocalTime startTime;

}
