package com.abigail221b.dentalClinic_backend.Appointment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDentistDTO {

    private int id;
    private String firstName;
    private String lastName;

}
