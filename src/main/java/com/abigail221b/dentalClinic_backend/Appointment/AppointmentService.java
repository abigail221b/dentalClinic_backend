package com.abigail221b.dentalClinic_backend.Appointment;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AppointmentService {

    List<Appointment> findAll();

    Optional<Appointment> findById(AppointmentIdDTO id);

    List<Appointment> findByPatientId(Integer patientId);

    List<Appointment> findByDentistId(Integer dentistId);

    List<Appointment> findByDate(LocalDate date);

    List<Appointment> findByDateAndDentistIdIn(LocalDate date, List<Integer> dentistIds);

    List<Appointment> findByDateRange(LocalDate after, LocalDate before);

    Appointment save(AppointmentDTO appointmentDTO);

    Appointment update(AppointmentDTO appointmentDTO);

    void delete(AppointmentIdDTO id);

}
