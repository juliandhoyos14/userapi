package co.com.users.usersapirest.usecase;

import co.com.users.usersapirest.model.Course;
import co.com.users.usersapirest.model.User;
import co.com.users.usersapirest.service.repository.EnrollmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class EnrollmentUseCase {

    private final EnrollmentRepository enrollmentRepository;

    public void enrollUserInCourse(String userId, String courseId) {
        enrollmentRepository.enrollUserInCourse(userId, courseId);
    }

    public void unenrollUserFromCourse(String userId, String courseId) {
        enrollmentRepository.unenrollUserFromCourse(userId, courseId);
    }

    public List<Course> getUserCourses(String userId) {
        return enrollmentRepository.getUserCourses(userId);
    }

    public List<User> getCourseUsers(String courseId) {
        return enrollmentRepository.getCourseUsers(courseId);
    }
}
