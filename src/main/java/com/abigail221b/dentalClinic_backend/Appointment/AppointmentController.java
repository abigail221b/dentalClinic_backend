package com.abigail221b.dentalClinic_backend.Appointment;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping
    public ResponseEntity<List<Appointment>> getAllAppointments() {
        return new ResponseEntity<>(appointmentService.findAll(), HttpStatus.OK);
    }

    @GetMapping(params = {"date"})
    public ResponseEntity<List<Appointment>> getAppointmentsByDate(@RequestParam("date") LocalDate date) {
        return new ResponseEntity<>(appointmentService.findByDate(date), HttpStatus.OK);
    }

    @GetMapping(params = {"date", "dentistIds"})
    public ResponseEntity<List<Appointment>> getAppointmentsByDate(
        @RequestParam("date") LocalDate date,
        @RequestParam("dentistIds") List<Integer> dentistIds) {

        return new ResponseEntity<>(appointmentService.findByDateAndDentistIdIn(date, dentistIds), HttpStatus.OK);
    }

    @GetMapping(params = {"before", "after"})
    public ResponseEntity<List<Appointment>> getAppointmentsByDateRange(
        @RequestParam("after") LocalDate after,
        @RequestParam("before") LocalDate before) {

        return new ResponseEntity<>(appointmentService.findByDateRange(after, before), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Appointment> saveAppointment(@RequestBody AppointmentDTO appointmentDTO) {
        return new ResponseEntity<>(appointmentService.save(appointmentDTO), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Appointment> updateAppointment(
            @MatrixVariable int patientId,
            @MatrixVariable LocalDate date,
            @MatrixVariable LocalTime startTime,
            @RequestBody AppointmentDTO appointmentDTO) {

        appointmentDTO.setId(new AppointmentIdDTO(patientId, date, startTime));
        return new ResponseEntity<>(appointmentService.update(appointmentDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppointment(
            @MatrixVariable int patientId,
            @MatrixVariable LocalDate date,
            @MatrixVariable LocalTime startTime) {

        appointmentService.delete(new AppointmentIdDTO(patientId, date, startTime));
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
