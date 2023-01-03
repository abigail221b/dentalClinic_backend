package com.abigail221b.dentalClinic_backend.Appointment;

import lombok.Data;

@Data
public class AppointmentDTO {
    
    private AppointmentIdDTO id;
    private int dentistId;
    private int duration;

}
