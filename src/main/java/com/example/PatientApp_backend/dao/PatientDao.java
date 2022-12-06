package com.example.PatientApp_backend.dao;

import com.example.PatientApp_backend.model.Patient;
import org.springframework.data.repository.CrudRepository;

public interface PatientDao extends CrudRepository<Patient,Integer> {
}
