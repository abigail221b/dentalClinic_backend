package com.abigail221b.dentalClinic_backend.Patient;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import com.abigail221b.dentalClinic_backend.Appointment.Appointment;
import com.abigail221b.dentalClinic_backend.Appointment.AppointmentService;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatients() {
        return new ResponseEntity<>(patientService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(patientService.findById(id).get(), HttpStatus.OK);
    }

    @RequestMapping(
        method = RequestMethod.GET,
        params = { "firstName" }    
    )
    public ResponseEntity<List<Patient>> getPatientsByFirstName(@RequestParam("firstName") String firstName) {
        return new ResponseEntity<>(patientService.findByFirstName(firstName), HttpStatus.OK);
    }

    @RequestMapping(
        method = RequestMethod.GET,
        params = { "lastName" }
    )
    public ResponseEntity<List<Patient>> getPatientsByLastName(@RequestParam("lastName") String lastName) {
        return new ResponseEntity<>(patientService.findByLastName(lastName), HttpStatus.OK);
    }

    @RequestMapping(
        method = RequestMethod.GET,
        params = { "phoneNumber" }
    )
    public ResponseEntity<List<Patient>> getPatientsByPhoneNumber(@RequestParam("phoneNumber") String phoneNumber) {
        return new ResponseEntity<>(patientService.findByPhoneNumber(phoneNumber), HttpStatus.OK);
    }

    @RequestMapping(
        method = RequestMethod.GET,
        params = { "firstName", "lastName" }
    )
    public ResponseEntity<List<Patient>> getPatientsByFirstNameAndLastName(
        @RequestParam("firstName") String firstName,
        @RequestParam("lastName") String lastName
    ) {
        return new ResponseEntity<>(patientService.findByFirstNameAndLastName(firstName, lastName), HttpStatus.OK);
    }

    @RequestMapping(
        method = RequestMethod.GET,
        params = { "firstName", "lastName", "dateOfBirth" }
    )
    public ResponseEntity<List<Patient>> getPatientsByFirstNameAndLastNameAndDateOfBirth(
        @RequestParam("firstName") String firstName,
        @RequestParam("lastName") String lastName,
        @RequestParam("dateOfBirth") Date dateOfBirth
    ) {
        return new ResponseEntity<>(patientService.findByFirstNameAndLastNameAndDateOfBirth(firstName, lastName, dateOfBirth), HttpStatus.OK);
    }

    @RequestMapping(
        method = RequestMethod.GET,
        params = { "firstName", "lastName", "phoneNumber" }
    )
    public ResponseEntity<List<Patient>> getPatientsByFirstNameAndLastNameAndDateOfBirth(
        @RequestParam("firstName") String firstName,
        @RequestParam("lastName") String lastName,
        @RequestParam("phoneNumber") String phoneNumber
    ) {
        return new ResponseEntity<>(patientService.findByFirstNameAndLastNameAndPhoneNumber(firstName, lastName, phoneNumber), HttpStatus.OK);
    }

    @RequestMapping(
        method = RequestMethod.GET,
        params = { "firstName", "lastName", "dateOfBirth", "phoneNumber" }
    )
    public ResponseEntity<List<Patient>> getPatientsByFirstNameAndLastNameAndDateOfBirth(
        @RequestParam("firstName") String firstName,
        @RequestParam("lastName") String lastName,
        @RequestParam("dateOfBirth") Date dateOfBirth,
        @RequestParam("phoneNumber") String phoneNumber
    ) {
        return new ResponseEntity<>(patientService.findByFirstNameAndLastNameAndDateOfBirthAndPhoneNumber(firstName, lastName, dateOfBirth, phoneNumber), HttpStatus.OK);
    }

    @GetMapping("/{id}/appointments")
    public ResponseEntity<List<Appointment>> getAppointmentsByPatientId(@PathVariable("id") Integer patientId) {
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
