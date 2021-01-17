package com.sandbox.demo.model;

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
    // @JsonProperty
    // private String testArray;
}
