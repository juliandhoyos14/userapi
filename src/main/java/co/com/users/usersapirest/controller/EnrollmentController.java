package co.com.users.usersapirest.controller;

import co.com.users.usersapirest.controller.dto.CourseDTO;
import co.com.users.usersapirest.controller.dto.UserDTO;
import co.com.users.usersapirest.usecase.EnrollmentUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/enrollments")
@AllArgsConstructor
public class EnrollmentController {

    private final EnrollmentUseCase enrollmentUseCase;

    @PostMapping("/users/{userId}/courses/{courseId}")
    public ResponseEntity<Void> enrollUserInCourse(@PathVariable String userId, @PathVariable String courseId) {
        enrollmentUseCase.enrollUserInCourse(userId, courseId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/users/{userId}/courses/{courseId}")
    public ResponseEntity<Void> unenrollUserFromCourse(@PathVariable String userId, @PathVariable String courseId) {
        enrollmentUseCase.unenrollUserFromCourse(userId, courseId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/users/{userId}/courses")
    public ResponseEntity<List<CourseDTO>> getUserCourses(@PathVariable String userId) {
        List<CourseDTO> courses = CourseDTO.fromModelList(enrollmentUseCase.getUserCourses(userId));
        return ResponseEntity.ok().body(courses);
    }

    @GetMapping("/courses/{courseId}/users")
    public ResponseEntity<List<UserDTO>> getCourseStudents(@PathVariable String courseId) {
        List<UserDTO> users = UserDTO.fromModelList(enrollmentUseCase.getCourseUsers(courseId));
        return ResponseEntity.ok().body(users);
    }
}
