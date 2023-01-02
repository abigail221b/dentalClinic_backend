package com.abigail221b.dentalClinic_backend.Dentist;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DentistServiceImpl implements DentistService {

    @Autowired
    private DentistRepository dentistRepository;

    @Override
    public List<Dentist> findAll() {
        return dentistRepository.findAll();
    }

    @Override
    public Optional<Dentist> findById(Integer id) {
        return dentistRepository.findById(id);
    }

    @Override
    public Dentist save(Dentist dentist) {
        return dentistRepository.save(dentist);
    }

    @Override
    public Dentist update(Dentist dentist) {
        return dentistRepository.save(dentist);
    }

    @Override
    public void delete(Integer id) {
        dentistRepository.deleteById(id);
    }

}
