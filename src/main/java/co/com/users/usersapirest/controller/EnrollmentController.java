package co.com.users.usersapirest.controller;

import co.com.users.usersapirest.usecase.EnrollmentUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/enrollments")
@AllArgsConstructor
public class EnrollmentController {

    private final EnrollmentUseCase enrollmentUseCase;
}
