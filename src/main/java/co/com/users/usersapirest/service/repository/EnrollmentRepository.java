package co.com.users.usersapirest.service.repository;

import co.com.users.usersapirest.model.Course;
import co.com.users.usersapirest.model.User;
import co.com.users.usersapirest.service.entity.CourseEntity;
import co.com.users.usersapirest.service.entity.UserEntity;

import java.util.List;

public interface EnrollmentRepository {

    /**
     * Matricula un usuario en un curso.
     *
     * @param userId ID del usuario
     * @param courseId ID del curso
     * @throws IllegalArgumentException si el usuario o curso no existe, o si ya esta matriculado
     */
    void enrollUserInCourse(String userId, String courseId);

    /**
     * Desmatricula un usuario de un curso.
     *
     * @param userId ID del usuario
     * @param courseId ID del curso
     * @throws IllegalArgumentException si el usuario o curso no existe
     */
    void unenrollUserFromCourse(String userId, String courseId);

    /**
     * Obtiene todos los cursos en los que esta matriculado un usuario.
     *
     * @param userId ID del usuario
     * @return Lista de cursos del usuario
     * @throws IllegalArgumentException si el usuario no existe
     */
    List<Course> getUserCourses(String userId);

    /**
     * Obtiene todos los estudiantes matriculados en un curso.
     *
     * @param courseId ID del curso
     * @return Lista de usuarios matriculados en el curso
     * @throws IllegalArgumentException si el curso no existe
     */
    List<User> getCourseUsers(String courseId);
}
