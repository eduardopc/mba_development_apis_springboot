package com.igti.apialuno.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Principal {

    @RequestMapping(method = RequestMethod.GET)
    public String helloWorld() {
        return "Olá, mundo!";
    }
}
