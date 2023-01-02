package com.abigail221b.dentalClinic_backend.Appointment;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public List<Appointment> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<Appointment> findById(AppointmentId id) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }

    @Override
    public Appointment save(Appointment Appointment) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Appointment update(Appointment Appointment) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void delete(AppointmentId id) {
        // TODO Auto-generated method stub
        
    }
    
}
