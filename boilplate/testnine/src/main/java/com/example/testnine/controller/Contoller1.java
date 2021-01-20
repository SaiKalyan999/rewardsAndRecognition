package com.example.testnine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Contoller1 {
        @Autowired
        private DataService dataService;

        @GetMapping("/{id}")


        public String getIden(@PathVariable String id) {
            return dataService.getIden(id);


        }
    }
