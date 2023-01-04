package com.abigail221b.dentalClinic_backend.Appointment;

import java.sql.Date;
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
    public Optional<Appointment> findById(AppointmentIdDTO id) {
        Patient patient = patientRepository.findById(id.getPatientId()).get();
        return appointmentRepository.findById(new AppointmentId(patient, id.getDate(), id.getStartTime()));
    }

    @Override
    public List<Appointment> findByPatientId(Integer patientId) {
        return appointmentRepository.findById_PatientId(patientId);
    }

    @Override
    public List<Appointment> findByDateRange(Date after, Date before) {
        return appointmentRepository.findById_DateBetween(after, before);
    }

    @Override
    public Appointment save(AppointmentDTO appointmentDTO) {
        AppointmentIdDTO id = appointmentDTO.getId();
        Patient patient = patientRepository.findById(id.getPatientId()).get();
        Dentist dentist = dentistRepository.findById(appointmentDTO.getDentistId()).get();
        return appointmentRepository.save(
            new Appointment(
                new AppointmentId(patient, id.getDate(), id.getStartTime()),
                dentist,
                appointmentDTO.getDuration()
            ));
    }

    @Override
    public Appointment update(AppointmentDTO appointmentDTO) {
        AppointmentIdDTO id = appointmentDTO.getId();
        Patient patient = patientRepository.findById(id.getPatientId()).get();
        Dentist dentist = dentistRepository.findById(appointmentDTO.getDentistId()).get();
        return appointmentRepository.save(
            new Appointment(
                new AppointmentId(patient, id.getDate(), id.getStartTime()),
                dentist,
                appointmentDTO.getDuration()
            ));
    }

    @Override
    public void delete(AppointmentIdDTO id) {
        Patient patient = patientRepository.findById(id.getPatientId()).get();
        appointmentRepository.deleteById(new AppointmentId(patient, id.getDate(), id.getStartTime()));
    }

}
