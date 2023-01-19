package com.abigail221b.dentalClinic_backend.Appointment;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentService {

    List<AppointmentDTO> findAll();

    AppointmentDTO findById(Integer id);

    List<AppointmentDTO> findByPatientId(Integer patientId);

    List<AppointmentDTO> findByDentistId(Integer dentistId);

    List<AppointmentDTO> findByDate(LocalDate date);

    List<AppointmentDTO> findByDateAndDentistIdIn(LocalDate date, List<Integer> dentistIds);

    List<AppointmentDTO> findByDateRange(LocalDate after, LocalDate before);

    List<AppointmentDTO> findByDateRangeAndDentistIdIn(LocalDate after, LocalDate before, List<Integer> dentistIds);

    List<AppointmentDTO> findByDateAfterAndPatientId(LocalDate after, Integer patientId);

    AppointmentDTO save(AppointmentDTO appointmentDTO);

    AppointmentDTO update(Integer id, AppointmentDTO appointmentDTO);

    void delete(Integer id);

}
