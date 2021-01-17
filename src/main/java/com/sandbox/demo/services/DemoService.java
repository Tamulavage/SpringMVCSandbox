package com.sandbox.demo.services;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.sandbox.demo.model.MockJSON;

import org.springframework.stereotype.Service;

@Service
public class DemoService {
    
    public JSONPObject convertJSONObject(JSONPObject o){
        // MockJSON mockJSON = o;
        
        return o;
    }
}
