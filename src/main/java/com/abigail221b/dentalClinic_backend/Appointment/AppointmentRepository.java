package com.abigail221b.dentalClinic_backend.Appointment;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, AppointmentId> {

    List<Appointment> findById_PatientId(Integer id);

    List<Appointment> findByDentist_Id(Integer id);

    List<Appointment> findById_DateBetween(Date after, Date before);

}
