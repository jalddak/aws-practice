-- 1. 데이터베이스 선택 (데이터베이스가 이미 생성되어 있다고 가정)
CREATE DATABASE aws_practice;

USE aws_practice;

-- 2. demo 테이블 생성 (스키마 정의)
DROP TABLE IF EXISTS demo;

CREATE TABLE demo (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      demo_code VARCHAR(50) NOT NULL UNIQUE,
                      name VARCHAR(100) NOT NULL,
                      description TEXT,
                      created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
                      updated_at DATETIME ON UPDATE CURRENT_TIMESTAMP
);

INSERT INTO demo (demo_code, name, description) VALUES
    ('DEMO_001', '테스트 데이터 1', '첫 번째 더미 데이터입니다.'),
    ('DEMO_002', '테스트 데이터 2', '중복 방지 컬럼 테스트용입니다.'),
    ('DEMO_003', '테스트 데이터 3', '마지막 더미 데이터입니다.');