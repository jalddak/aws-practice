package com.hjhan.aws_practice.demo;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class DemoCreateRequest {

    @NotNull(message = "Demo code is required.")
    @Size(min = 2, max = 50)
    private String demoCode;

    @NotNull(message = "Name is required.")
    @Size(min = 2, max = 100)
    private String name;

    private String description;
}
