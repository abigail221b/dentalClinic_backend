package com.abigail221b.dentalClinic_backend.Appointment;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, AppointmentId> {

    List<Appointment> findById_PatientId(Integer id);

    List<Appointment> findByDentist_Id(Integer id);

    List<Appointment> findById_DateBetween(LocalDate after, LocalDate before);

    List<Appointment> findById_DateBetweenAndDentistIdIn(LocalDate after, LocalDate before, List<Integer> dentistIds);

    List<Appointment> findById_Date(LocalDate date);

    List<Appointment> findById_DateAndDentistIdIn(LocalDate date, List<Integer> dentistIds);

}
