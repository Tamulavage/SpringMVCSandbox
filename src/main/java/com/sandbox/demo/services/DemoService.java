package com.sandbox.demo.services;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.sandbox.demo.model.MockJSON;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DemoService {

    private ObjectMapper objectMapper = new ObjectMapper();

    public Object convertMockJSONObject(MockJSON mockJSON) {
        mockJSON.setTest("test2");
        return mockJSON;
    }

    public Object convertJSONObject(String o) {
        JsonNode inputJSON;
        try {

            inputJSON = objectMapper.readTree(o);

            inputJSON.forEach(e -> {
                ObjectNode node = (ObjectNode) e;
                node.put("test", node.get("test").textValue() + " TEST");

                // hold is list of string to convert/change
                List<String> hold = new ArrayList<>();
                node.get("testArray").forEach(arrayElement -> {
                    hold.add(arrayElement.textValue() + "1");
                });

                node.putArray("testArray").addAll((ArrayNode) objectMapper.valueToTree(hold));

            });

            return objectMapper.writeValueAsString(inputJSON);

        } catch (Exception e) {
            log.error("{}", e);
        }

        return null;
    }
}
