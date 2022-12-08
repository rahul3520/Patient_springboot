package com.example.PatientApp_backend.controller;

import com.example.PatientApp_backend.dao.PatientDao;
import com.example.PatientApp_backend.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class PatientController {

    @Autowired
    private PatientDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/add",produces = "application/json",consumes = "application/json")
    public HashMap<String,String> AddPatient(@RequestBody Patient p)
    {
        HashMap<String,String> map=new HashMap<>();

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

        map.put("status","success");

        return map;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/view")
    public List<Patient> ViewPatient()
    {
        return(List<Patient>) dao.findAll();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/search",produces = "application/json",consumes = "application/json")
    public List<Patient> SearchPatient(@RequestBody Patient p)
    {
        String patid=String.valueOf(p.getPatientID());
        System.out.println(patid);

        return (List<Patient>) dao.Search(p.getPatientID());
    }

    @CrossOrigin(origins="*")
    @PostMapping(path = "/delete",produces = "application/json",consumes = "application/json")
    public HashMap<String,String> DeletePatient(@RequestBody Patient p)
    {
        String patid=String.valueOf(p.getId());
        System.out.println(patid);

        dao.Delete(p.getId());

        HashMap<String,String> map=new HashMap<>();

        map.put("status","success");

        return map;
    }

}
