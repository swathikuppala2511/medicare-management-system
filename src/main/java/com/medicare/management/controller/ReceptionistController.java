package com.medicare.management.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medicare.management.entity.Receptionist;
import com.medicare.management.repository.ReceptionistRepository;

@RestController
@RequestMapping("/receptionists")
public class ReceptionistController {

    private final ReceptionistRepository receptionistRepository;

    public ReceptionistController(ReceptionistRepository receptionistRepository) {
        this.receptionistRepository = receptionistRepository;
    }

    @GetMapping
    public List<Receptionist> getAllReceptionists() {
        return receptionistRepository.findAll();
    }

    @PostMapping
    public Receptionist saveReceptionist(@RequestBody Receptionist receptionist) {
        return receptionistRepository.save(receptionist);
    }
}