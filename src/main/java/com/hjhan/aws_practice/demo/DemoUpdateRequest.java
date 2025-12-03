package com.hjhan.aws_practice.demo;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class DemoUpdateRequest {

    @NotNull(message = "Name is required.")
    @Size(min = 2, max = 100)
    private String name;

    private String description;
}
