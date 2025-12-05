package com.hjhan.aws_practice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HomeController {

    @Value("${DB_HOST}")
    private String dbHost;

    @Value("${DB_NAME}")
    private String dbName;

    @GetMapping
    public String check() {
        StringBuilder sb = new StringBuilder();
        sb.append("DB_HOST : ").append(dbHost).append("\n");
        sb.append("DB_NAME : ").append(dbName).append("\n");

        return sb.toString();
    }
}
