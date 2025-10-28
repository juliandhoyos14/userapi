-- =====================================================
-- Base de datos: usersapi
-- Script para crear tablas
-- =====================================================

USE userapi;

CREATE TABLE users (
  id varchar(255) NOT NULL,
  name varchar(50) NOT NULL,
  email varchar(255) NOT NULL,
  age int DEFAULT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE courses (
    id VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    credits INT NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE user_courses (
    user_id VARCHAR(255) NOT NULL,
    course_id VARCHAR(255) NOT NULL,
    PRIMARY KEY (user_id, course_id),
    CONSTRAINT fk_user_courses_user 
        FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    CONSTRAINT fk_user_courses_course 
        FOREIGN KEY (course_id) REFERENCES courses(id) ON DELETE CASCADE
);

-- =====================================================
-- Datos de ejemplo para courses
-- =====================================================
INSERT INTO courses (id, name, description, credits) VALUES
('course-001', 'Programación Orientada a Objetos', 'Aprende los fundamentos de POO con Java', 4),
('course-002', 'Bases de Datos', 'Diseño y manejo de bases de datos relacionales', 3),
('course-003', 'Desarrollo Web', 'Creación de aplicaciones web con Spring Boot', 4),
('course-004', 'Algoritmos y Estructuras de Datos', 'Fundamentos de algoritmos y complejidad computacional', 5),
('course-005', 'Arquitectura de Software', 'Patrones de diseño y principios SOLID', 3)
ON DUPLICATE KEY UPDATE name=name;
