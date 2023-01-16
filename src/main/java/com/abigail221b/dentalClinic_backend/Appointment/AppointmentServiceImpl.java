package com.abigail221b.dentalClinic_backend.Appointment;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
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

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<AppointmentDTO> findAll() {
        return appointmentRepository.findAll()
                    .stream()
                    .map(appointment -> modelMapper.map(appointment, AppointmentDTO.class))
                    .collect(Collectors.toList());
    }

    @Override
    public AppointmentDTO findById(Integer id) {
        return appointmentRepository.findById(id);
    }

    @Override
    public List<AppointmentDTO> findByPatientId(Integer patientId) {
        return appointmentRepository.findByPatient_Id(patientId)
                    .stream()
                    .map(appointment -> modelMapper.map(appointment, AppointmentDTO.class))
                    .collect(Collectors.toList());
    }

    @Override
    public List<AppointmentDTO> findByDentistId(Integer dentistId) {
        return appointmentRepository.findByDentist_Id(dentistId)
                    .stream()
                    .map(appointment -> modelMapper.map(appointment, AppointmentDTO.class))
                    .collect(Collectors.toList());
    }

    @Override
    public List<AppointmentDTO> findByDate(LocalDate date) {
        return appointmentRepository.findByDate(date)
                    .stream()
                    .map(appointment -> modelMapper.map(appointment, AppointmentDTO.class))
                    .collect(Collectors.toList());
    }

    @Override
    public List<AppointmentDTO> findByDateAndDentistIdIn(LocalDate date, List<Integer> dentistIds) {
        return appointmentRepository.findByDateAndDentistIdIn(date, dentistIds)
                    .stream()
                    .map(appointment -> modelMapper.map(appointment, AppointmentDTO.class))
                    .collect(Collectors.toList());
    }

    @Override
    public List<AppointmentDTO> findByDateRange(LocalDate after, LocalDate before) {
        return appointmentRepository.findByDateBetween(after, before)
                    .stream()
                    .map(appointment -> modelMapper.map(appointment, AppointmentDTO.class))
                    .collect(Collectors.toList());
    }

    @Override
    public List<AppointmentDTO> findByDateRangeAndDentistIdIn(LocalDate after, LocalDate before, List<Integer> dentistIds) {
        return appointmentRepository.findByDateBetweenAndDentistIdIn(after, before, dentistIds)
                    .stream()
                    .map(appointment -> modelMapper.map(appointment, AppointmentDTO.class))
                    .collect(Collectors.toList());;
    }

    @Override
    public AppointmentDTO save(AppointmentDTO appointmentDTO) {
        Patient patient = patientRepository.findById(appointmentDTO.getPatientId()).get();
        Dentist dentist = dentistRepository.findById(appointmentDTO.getDentistId()).get();

        Appointment appointment = new Appointment();
        appointment.setPatient(patient);
        appointment.setDate(appointmentDTO.getDate());
        appointment.setStartTime(appointmentDTO.getStartTime());
        appointment.setDentist(dentist);
        appointment.setDuration(appointmentDTO.getDuration());

        return appointmentRepository.save(appointment);
    }

    @Override
    public AppointmentDTO update(Integer id, AppointmentDTO appointmentDTO) {
        Patient patient = patientRepository.findById(appointmentDTO.getPatientId()).get();
        Dentist dentist = dentistRepository.findById(appointmentDTO.getDentistId()).get();

        Appointment appointment = new Appointment();
        appointment.setId(id);
        appointment.setPatient(patient);
        appointment.setDate(appointmentDTO.getDate());
        appointment.setStartTime(appointmentDTO.getStartTime());
        appointment.setDentist(dentist);
        appointment.setDuration(appointmentDTO.getDuration());

        return appointmentRepository.save(appointment);
    }

    @Override
    public void delete(Integer id) {
        appointmentRepository.deleteById(id);
    }

}
