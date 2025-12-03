package com.hjhan.aws_practice.demo;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@JsonPropertyOrder({"id", "demoCode", "name", "description"})
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DemoResponse {

    private Long id;
    private String demoCode;
    private String name;
    private String description;


    private DemoResponse(Long id, String demoCode, String name, String description) {
        this.id = id;
        this.demoCode = demoCode;
        this.name = name;
        this.description = description;
    }

    public static DemoResponse from(Demo demo) {
        return new DemoResponse(demo.getId(), demo.getDemoCode(), demo.getName(), demo.getDescription());
    }
}
