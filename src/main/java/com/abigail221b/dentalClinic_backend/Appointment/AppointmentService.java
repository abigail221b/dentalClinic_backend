package com.abigail221b.dentalClinic_backend.Appointment;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface AppointmentService {
    
    List<Appointment> findAll();

    Optional<Appointment> findById(AppointmentIdDTO id);

    List<Appointment> findByPatientId(Integer patientId);

    List<Appointment> findByDateRange(Date after, Date before);

    Appointment save(AppointmentDTO appointmentDTO);

    Appointment update(AppointmentDTO appointmentDTO);

    void delete(AppointmentIdDTO id);

}
