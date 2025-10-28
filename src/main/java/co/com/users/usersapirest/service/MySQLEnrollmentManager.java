package co.com.users.usersapirest.service;

import co.com.users.usersapirest.model.Course;
import co.com.users.usersapirest.model.User;
import co.com.users.usersapirest.service.datarepository.SpringDataCourseRepository;
import co.com.users.usersapirest.service.datarepository.SpringDataUserRepository;
import co.com.users.usersapirest.service.entity.CourseEntity;
import co.com.users.usersapirest.service.entity.UserEntity;
import co.com.users.usersapirest.service.repository.EnrollmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MySQLEnrollmentManager implements EnrollmentRepository {

    private final SpringDataUserRepository userRepo;
    private final SpringDataCourseRepository courseRepo;

    @Override
    public void enrollUserInCourse(String userId, String courseId) {
        UserEntity user = userRepo.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Usuario con ID " + userId + " no encontrado."));
        CourseEntity course = courseRepo.findById(courseId)
                .orElseThrow(() -> new IllegalArgumentException("Curso con ID " + courseId + " no encontrado."));
        if (user.getCoursesList().contains(course)) {
            throw new IllegalArgumentException("El usuario ya está matriculado en este curso.");
        } else {
            user.getCoursesList().add(course);
            userRepo.save(user);
        }
    }

    @Override
    public void unenrollUserFromCourse(String userId, String courseId) {
        UserEntity user = userRepo.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Usuario con ID " + userId + " no encontrado."));

        CourseEntity course = courseRepo.findById(courseId)
                .orElseThrow(() -> new IllegalArgumentException("Curso con ID " + courseId + " no encontrado."));

        if (!user.getCoursesList().contains(course)) {
            throw new IllegalArgumentException("El usuario no está matriculado en este curso.");
        } else {
            user.getCoursesList().remove(course);
            userRepo.save(user);
        }
    }

    @Override
    public List<Course> getUserCourses(String userId) {
        UserEntity user = userRepo.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Usuario con ID " + userId + " no encontrado."));

        return CourseEntity.toModelList(user.getCoursesList());
    }

    @Override
    public List<User> getCourseUsers(String courseId) {
        CourseEntity course = courseRepo.findById(courseId)
                .orElseThrow(() -> new IllegalArgumentException("Curso con ID " + courseId + " no encontrado."));

        return UserEntity.toModelList(course.getUsers());
    }
}
