package co.com.users.usersapirest.controller;

import co.com.users.usersapirest.model.User;
import co.com.users.usersapirest.usecase.UserUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserUseCase userUseCase;

    public ResponseEntity<?> getUsers(Integer minAge, Integer maxAge) {
        return null;
    }

    public ResponseEntity<?> getUserById(String id) {
        return null;
    }

    public ResponseEntity<?> createUser(User user) {
        return null;
    }

    public ResponseEntity<?> updateUser(String id, User user) {
        return null;
    }

    public ResponseEntity<Void> deleteUser(String id) {
        return null;
    }
}
