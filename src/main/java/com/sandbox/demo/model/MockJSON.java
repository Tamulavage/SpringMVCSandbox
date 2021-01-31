package com.sandbox.demo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class MockJSON {
    @JsonProperty
    private String test;
    @JsonProperty
    private List<String>  testArray;
}
