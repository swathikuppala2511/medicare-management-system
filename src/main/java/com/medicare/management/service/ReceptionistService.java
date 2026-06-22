package com.medicare.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicare.management.entity.Receptionist;
import com.medicare.management.exception.ResourceNotFoundException;
import com.medicare.management.repository.ReceptionistRepository;

@Service
public class ReceptionistService {

    @Autowired
    private ReceptionistRepository receptionistRepository;

    // Add Receptionist
    public Receptionist saveReceptionist(Receptionist receptionist) {

        return receptionistRepository.save(receptionist);
    }

    // Get All Receptionists
    public List<Receptionist> getAllReceptionists() {

        return receptionistRepository.findAll();
    }

    // Get Receptionist By Id
    public Receptionist getReceptionistById(Integer id) {

        return receptionistRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Receptionist Not Found"));
    }

    // Update Receptionist
    public Receptionist updateReceptionist(Integer id, Receptionist receptionistDetails) {

        Receptionist receptionist = receptionistRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Receptionist Not Found"));

        receptionist.setName(receptionistDetails.getName());
        receptionist.setShiftTime(receptionistDetails.getShiftTime());

        return receptionistRepository.save(receptionist);
    }

    // Delete Receptionist
    public String deleteReceptionist(Integer id) {

        Receptionist receptionist = receptionistRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Receptionist Not Found"));

        receptionistRepository.delete(receptionist);

        return "Receptionist Deleted Successfully";
    }
}
