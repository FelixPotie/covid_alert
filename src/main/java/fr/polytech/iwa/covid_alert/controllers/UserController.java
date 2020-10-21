package fr.polytech.iwa.covid_alert.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping()
    public String get(){
        return "ATTENTION COVID DANGEREUX";
    }
}
