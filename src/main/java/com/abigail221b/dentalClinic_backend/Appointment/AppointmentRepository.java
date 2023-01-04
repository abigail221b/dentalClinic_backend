package com.abigail221b.dentalClinic_backend.Appointment;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, AppointmentId> {

    List<Appointment> findById_PatientId(Integer id);

}
