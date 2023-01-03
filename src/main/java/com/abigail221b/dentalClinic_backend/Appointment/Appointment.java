package com.abigail221b.dentalClinic_backend.Appointment;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
    private int dentistId;
    private int duration;

}
