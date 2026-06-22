package com.medicare.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicare.management.entity.Patient;
import com.medicare.management.exception.ResourceNotFoundException;
import com.medicare.management.repository.PatientRepository;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    // Add Patient
    public Patient savePatient(Patient patient) {

        return patientRepository.save(patient);
    }

    // Get All Patients
    public List<Patient> getAllPatients() {

        return patientRepository.findAll();
    }

    // Get Patient By Id
    public Patient getPatientById(Integer id) {

        return patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient Not Found"));
    }

    // Update Patient
    public Patient updatePatient(Integer id, Patient patientDetails) {

        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient Not Found"));

        patient.setName(patientDetails.getName());
        patient.setAge(patientDetails.getAge());
        patient.setDisease(patientDetails.getDisease());

        return patientRepository.save(patient);
    }

    // Delete Patient
    public String deletePatient(Integer id) {

        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient Not Found"));

        patientRepository.delete(patient);

        return "Patient Deleted Successfully";
    }
    public List<Patient> getPatientsByDisease(String disease) {

        return patientRepository.findByDisease(disease);
    }
}
