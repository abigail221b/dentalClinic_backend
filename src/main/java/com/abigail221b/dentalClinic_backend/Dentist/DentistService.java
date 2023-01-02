package com.abigail221b.dentalClinic_backend.Dentist;

import java.util.List;
import java.util.Optional;

public interface DentistService {
    
    List<Dentist> findAll();

    Optional<Dentist> findById(Integer id);

    Dentist save(Dentist dentist);

    Dentist update(Dentist dentist);

    void delete(Integer id);

}
