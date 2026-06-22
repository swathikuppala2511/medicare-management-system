package com.medicare.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medicare.management.entity.Patient;
import com.medicare.management.repository.PatientRepository;
import com.medicare.management.service.PatientService;

@RestController
@RequestMapping("/patients")
public class PatientController {
	@Autowired
    private PatientService patientService;
	
    private final PatientRepository patientRepository;

    public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @GetMapping
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @PostMapping
    public Patient savePatient(@RequestBody Patient patient) {
        return patientRepository.save(patient);
    }
    @GetMapping("/disease/{disease}")
    public List<Patient> getPatientsByDisease(
            @PathVariable String disease) {

        return patientService.getPatientsByDisease(disease);
    }
    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable Integer id) {

        return patientService.getPatientById(id);
    }
}
