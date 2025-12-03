package com.hjhan.aws_practice.demo;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "demo") // DB 테이블명 명시
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // JPA 스펙상 기본 생성자 필수
public class Demo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Long id;

    // demo_code VARCHAR(50) NOT NULL UNIQUE
    @Column(name = "demo_code", length = 50, nullable = false, unique = true)
    private String demoCode;

    // name VARCHAR(100) NOT NULL
    @Column(nullable = false, length = 100)
    private String name;

    // description TEXT
    @Column(columnDefinition = "TEXT")
    private String description;

    // created_at DATETIME DEFAULT CURRENT_TIMESTAMP
    @CreationTimestamp // Hibernate가 INSERT 시점에 시간을 자동 저장해줌
    @Column(name = "created_at", updatable = false) // 수정 불가 설정
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    private Demo(String demoCode, String name, String description) {
        this.demoCode = demoCode;
        this.name = name;
        this.description = description;
    }

    public static Demo create(DemoCreateRequest request) {
        return new Demo(request.getDemoCode(), request.getName(), request.getDescription());
    }

    public void update(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
