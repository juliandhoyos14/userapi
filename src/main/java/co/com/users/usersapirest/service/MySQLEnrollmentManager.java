package co.com.users.usersapirest.service;

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

    }

    @Override
    public void unenrollUserFromCourse(String userId, String courseId) {

    }

    @Override
    public List<CourseEntity> getUserCourses(String userId) {
        return List.of();
    }

    @Override
    public List<UserEntity> getCourseUsers(String courseId) {
        return List.of();
    }
}
