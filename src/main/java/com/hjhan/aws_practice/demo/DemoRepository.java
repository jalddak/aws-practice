package com.hjhan.aws_practice.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DemoRepository extends JpaRepository<Demo, Long> {

    boolean existsDemoByDemoCode(String demoCode);
}
