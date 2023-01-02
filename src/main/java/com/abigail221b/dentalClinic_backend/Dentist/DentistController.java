package com.abigail221b.dentalClinic_backend.Dentist;

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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dentists")
public class DentistController {
    
    @Autowired
    private DentistService dentistService;

    @GetMapping
    public ResponseEntity<List<Dentist>> getAllDentists() {
        return new ResponseEntity<>(dentistService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dentist> getDentistById(@PathVariable("id") Integer id) {
        return new ResponseEntity<Dentist>(dentistService.findById(id).get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Dentist> saveDentist(@RequestBody Dentist dentist) {
        return new ResponseEntity<>(dentistService.save(dentist), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dentist> updateDentist(@PathVariable("id") Integer id, @RequestBody Dentist dentist) {
        dentist.setId(id);
        return new ResponseEntity<>(dentistService.update(dentist), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDentist(@PathVariable("id") Integer id) {
        dentistService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
