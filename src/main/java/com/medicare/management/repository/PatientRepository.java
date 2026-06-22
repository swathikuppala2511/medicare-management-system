package com.medicare.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medicare.management.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
	List<Patient> findByDisease(String disease);
}
