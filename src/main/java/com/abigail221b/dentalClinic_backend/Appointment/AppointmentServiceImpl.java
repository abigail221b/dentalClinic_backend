package com.abigail221b.dentalClinic_backend.Appointment;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abigail221b.dentalClinic_backend.Dentist.Dentist;
import com.abigail221b.dentalClinic_backend.Dentist.DentistRepository;
import com.abigail221b.dentalClinic_backend.Patient.Patient;
import com.abigail221b.dentalClinic_backend.Patient.PatientRepository;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DentistRepository dentistRepository;

    @Override
    public List<Appointment> findAll() {
        return appointmentRepository.findAll();
    }

    @Override
    public Optional<Appointment> findById(Integer id) {
        return appointmentRepository.findById(id);
    }

    @Override
    public List<Appointment> findByPatientId(Integer patientId) {
        return appointmentRepository.findById_PatientId(patientId);
    }

    @Override
    public List<Appointment> findByDentistId(Integer dentistId) {
        return appointmentRepository.findByDentist_Id(dentistId);
    }

    @Override
    public List<Appointment> findByDate(LocalDate date) {
        return appointmentRepository.findById_Date(date);
    }

    @Override
    public List<Appointment> findByDateAndDentistIdIn(LocalDate date, List<Integer> dentistIds) {
        return appointmentRepository.findById_DateAndDentistIdIn(date, dentistIds);
    }

    @Override
    public List<Appointment> findByDateRange(LocalDate after, LocalDate before) {
        return appointmentRepository.findById_DateBetween(after, before);
    }

    @Override
    public List<Appointment> findByDateRangeAndDentistIdIn(LocalDate after, LocalDate before, List<Integer> dentistIds) {
        return appointmentRepository.findById_DateBetweenAndDentistIdIn(after, before, dentistIds);
    }

    @Override
    public Appointment save(AppointmentDTO appointmentDTO) {
        Patient patient = patientRepository.findById(appointmentDTO.getPatientId()).get();
        Dentist dentist = dentistRepository.findById(appointmentDTO.getDentistId()).get();

        Appointment appointment = new Appointment();
        appointment.setPatient(patient);
        appointment.setDate(appointmentDTO.getDate());
        appointment.setStartTime(appointmentDTO.getTime());
        appointment.setDentist(dentist);
        appointment.setDuration(appointmentDTO.getDuration());

        return appointmentRepository.save(appointment);
    }

    @Override
    public Appointment update(Integer id, AppointmentDTO appointmentDTO) {
        Patient patient = patientRepository.findById(appointmentDTO.getPatientId()).get();
        Dentist dentist = dentistRepository.findById(appointmentDTO.getDentistId()).get();

        Appointment appointment = new Appointment();
        appointment.setId(id);
        appointment.setPatient(patient);
        appointment.setDate(appointmentDTO.getDate());
        appointment.setStartTime(appointmentDTO.getTime());
        appointment.setDentist(dentist);
        appointment.setDuration(appointmentDTO.getDuration());

        return appointmentRepository.save(appointment);
    }

    @Override
    public void delete(Integer id) {
        appointmentRepository.deleteById(id);
    }

}
