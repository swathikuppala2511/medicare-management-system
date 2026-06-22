package com.medicare.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medicare.management.entity.Doctor;
import com.medicare.management.repository.DoctorRepository;
import com.medicare.management.service.DoctorService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    private final DoctorRepository doctorRepository;
    
    @Autowired
    private DoctorService doctorService;

    public DoctorController(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @GetMapping
    public List<Doctor> getAllDoctors() {
    	return doctorService.getAllDoctors();
    }

    @PostMapping
    public Doctor saveDoctor(@Valid @RequestBody Doctor doctor) {
        return doctorRepository.save(doctor);
    }
    @GetMapping("/specialization/{specialization}")
    public List<Doctor> getDoctorsBySpecialization(
            @PathVariable String specialization) {

        return doctorService.getDoctorsBySpecialization(specialization);
    }
    @GetMapping("/{id}")
    public Doctor getDoctorById(@PathVariable Integer id) {

        return doctorService.getDoctorById(id);
    }
    @PutMapping("/{id}")
    public Doctor updateDoctor(
            @PathVariable Integer id,
            @RequestBody Doctor doctor) {

        return doctorService.updateDoctor(id, doctor);
    }

    @DeleteMapping("/{id}")
    public String deleteDoctor(@PathVariable Integer id) {

        return doctorService.deleteDoctor(id);
    }
}