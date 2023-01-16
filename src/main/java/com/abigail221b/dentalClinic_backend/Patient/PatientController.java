package com.abigail221b.dentalClinic_backend.Patient;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abigail221b.dentalClinic_backend.Appointment.AppointmentDTO;
import com.abigail221b.dentalClinic_backend.Appointment.AppointmentService;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(patientService.findById(id).get(), HttpStatus.OK);
    }

    @RequestMapping(
        method = RequestMethod.GET
    )
    public ResponseEntity<List<Patient>> getPatients(
        @RequestParam(name = "firstName", required = false) String firstName,
        @RequestParam(name = "lastName", required = false) String lastName,
        @RequestParam(name = "dateOfBirth", required = false) LocalDate dateOfBirth,
        @RequestParam(name = "phoneNumber", required = false) String phoneNumber
    ) {
        return new ResponseEntity<>(patientService.findBySearchParams(firstName, lastName, dateOfBirth, phoneNumber), HttpStatus.OK);
    }

    @GetMapping("/{id}/appointments")
    public ResponseEntity<List<AppointmentDTO>> getAppointmentsByPatientId(@PathVariable("id") Integer patientId) {
        return new ResponseEntity<>(appointmentService.findByPatientId(patientId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Patient> savePatient(@RequestBody Patient patient) {
        return new ResponseEntity<>(patientService.save(patient), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable("id") Integer id, @RequestBody Patient patient) {
        patient.setId(id);
        return new ResponseEntity<>(patientService.update(patient), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable("id") Integer id) {
        patientService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
