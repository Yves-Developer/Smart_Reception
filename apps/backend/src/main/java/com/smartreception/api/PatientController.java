package com.smartreception.api;

import com.smartreception.model.Patient;
import com.smartreception.service.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/patients")
@Tag(name = "Patient API", description = "Endpoints for patient management")
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    @Operation(summary = "Get all patients")
    public List<Patient> getAllPatients() {
        return patientService.findAll();
    }

    @PostMapping
    @Operation(summary = "Create a new patient")
    public Patient createPatient(@RequestBody Patient patient) {
        return patientService.save(patient);
    }
}
