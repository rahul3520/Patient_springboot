package com.example.PatientApp_backend.controller;

import com.example.PatientApp_backend.dao.PatientDao;
import com.example.PatientApp_backend.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PatientController {

    @Autowired
    private PatientDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/add",produces = "application/json",consumes = "application/json")
    public String AddPatient(@RequestBody Patient p)
    {
        System.out.println(p.toString());
        System.out.println(p.getPatientID());
        System.out.println(p.getPatientName().toString());
        System.out.println(p.getDob().toString());
        System.out.println(p.getGender().toString());
        System.out.println(p.getPhoneNo().toString());
        System.out.println(p.getDoctorID());
        System.out.println(p.getDoctorName().toString());
        System.out.println(p.getRoomNo());

        dao.save(p);

        return "patient added";
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/view")
    public String ViewPatient()
    {
        return "view patient";
    }

}
