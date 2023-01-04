package com.abigail221b.dentalClinic_backend.Appointment;

import java.sql.Date;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
    
    @Autowired
    private AppointmentService appointmentService;

    @GetMapping
    public ResponseEntity<List<Appointment>> getAllAppointments() {
        return new ResponseEntity<>(appointmentService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Appointment> saveAppointment(@RequestBody AppointmentDTO appointmentDTO) {
        return new ResponseEntity<>(appointmentService.save(appointmentDTO), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Appointment> updateAppointment(
            @MatrixVariable int patientId, 
            @MatrixVariable Date date,
            @MatrixVariable LocalTime startTime,
            @RequestBody AppointmentDTO appointmentDTO) {
                
        appointmentDTO.setId(new AppointmentIdDTO(patientId, date, startTime));
        return new ResponseEntity<>(appointmentService.update(appointmentDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppointment(
            @MatrixVariable int patientId, 
            @MatrixVariable Date date,
            @MatrixVariable LocalTime startTime) {

        appointmentService.delete(new AppointmentIdDTO(patientId, date, startTime));
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
