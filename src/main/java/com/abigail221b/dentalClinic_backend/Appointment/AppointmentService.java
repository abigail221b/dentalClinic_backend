package com.abigail221b.dentalClinic_backend.Appointment;

import java.util.List;
import java.util.Optional;

public interface AppointmentService {
    
    List<Appointment> findAll();

    Optional<Appointment> findById(Integer id);

    Appointment save(Appointment Appointment);

    Appointment update(Appointment Appointment);

    void delete(Integer id);

}
