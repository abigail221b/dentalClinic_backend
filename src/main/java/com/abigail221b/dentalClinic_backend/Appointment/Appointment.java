package com.abigail221b.dentalClinic_backend.Appointment;

import com.abigail221b.dentalClinic_backend.Dentist.Dentist;

import jakarta.persistence.EmbeddedId;
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
    
    @EmbeddedId
    private AppointmentId id;

    @ManyToOne
    @JoinColumn(
        name = "appointment_dentist",
        referencedColumnName = "id"
    )
    private Dentist dentist;

    private int duration;

}
