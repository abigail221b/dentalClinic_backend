package com.abigail221b.dentalClinic_backend.Appointment;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

    List<Appointment> findByPatient_Id(Integer id);

    List<Appointment> findByDentist_Id(Integer id);

    List<Appointment> findByDateBetween(LocalDate after, LocalDate before);

    List<Appointment> findByDateBetweenAndDentistIdIn(LocalDate after, LocalDate before, List<Integer> dentistIds);

    List<Appointment> findByDate(LocalDate date);

    List<Appointment> findByDateAndDentistIdIn(LocalDate date, List<Integer> dentistIds);

}
