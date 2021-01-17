package com.sandbox.demo.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.sandbox.demo.services.DemoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/demo")
public class DemoController {

    private DemoService demoService;

    @Autowired
    public DemoController(DemoService demoService){
        this.demoService = demoService;
    }

    @GetMapping("/")
    public ResponseEntity<String> getDemo(){
        log.info("getDemo initiated");
        return new ResponseEntity<>("good", HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Object> postDemo(@RequestBody Object o){
        log.info("postDemo initiated");
        return new ResponseEntity<>(o, HttpStatus.OK);
    }
    
    @PostMapping("/convert")
    public ResponseEntity<Object> convertDemo(@RequestBody JSONPObject o){
        log.info("convertDemo initiated");
        return new ResponseEntity<>(demoService.convertJSONObject(o), HttpStatus.OK);
    }
}
