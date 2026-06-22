package com.medicare.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicare.management.entity.Doctor;
import com.medicare.management.exception.ResourceNotFoundException;
import com.medicare.management.repository.DoctorRepository;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    // Add Doctor
    public Doctor saveDoctor(Doctor doctor) {

        return doctorRepository.save(doctor);
    }

    // Get All Doctors
    public List<Doctor> getAllDoctors() {

        return doctorRepository.findAll();
    }

    // Get Doctor By Id
    public Doctor getDoctorById(Integer id) {

        return doctorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor Not Found"));
    }

    // Update Doctor
    public Doctor updateDoctor(Integer id, Doctor doctorDetails) {

        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor Not Found"));

        doctor.setName(doctorDetails.getName());
        doctor.setSpecialization(doctorDetails.getSpecialization());
        doctor.setPhone(doctorDetails.getPhone());

        return doctorRepository.save(doctor);
    }

    // Delete Doctor
    public String deleteDoctor(Integer id) {

        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor Not Found"));

        doctorRepository.delete(doctor);

        return "Doctor Deleted Successfully";
    }
    public List<Doctor> getDoctorsBySpecialization(String specialization) {

        return doctorRepository.findBySpecialization(specialization);
    }
   
}