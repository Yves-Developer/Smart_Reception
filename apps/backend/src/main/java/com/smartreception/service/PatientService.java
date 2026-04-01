package com.smartreception.service;

import com.smartreception.model.Patient;
import com.smartreception.repository.PatientRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class PatientService {
    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }
}
