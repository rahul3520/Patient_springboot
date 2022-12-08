package com.example.PatientApp_backend.dao;

import com.example.PatientApp_backend.model.Patient;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PatientDao extends CrudRepository<Patient,Integer> {

    @Query(value="SELECT `id`, `dob`, `doctorid`, `doctor_name`, `gender`, `patientid`, `patient_name`, `phone_no`, `room_no` FROM `patients` WHERE `patientid`=:patientID",nativeQuery = true)
    List<Patient> Search(@Param("patientID") Integer patientID);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM `patients` WHERE `id`=:id",nativeQuery = true)
    void Delete(@Param("id") Integer id);
}
