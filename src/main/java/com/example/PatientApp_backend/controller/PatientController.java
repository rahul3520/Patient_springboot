package com.example.PatientApp_backend.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/add",produces = "application/json",consumes = "application/json")
    public String AddPatient()
    {
        return "patient added";
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/view")
    public String ViewPatient()
    {
        return "view patient";
    }

}
