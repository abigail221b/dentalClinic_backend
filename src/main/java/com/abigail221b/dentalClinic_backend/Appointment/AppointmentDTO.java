package com.abigail221b.dentalClinic_backend.Appointment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDTO {
    
    private AppointmentIdDTO id;
    private int dentistId;
    private int duration;

}
