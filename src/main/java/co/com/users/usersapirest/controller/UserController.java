package co.com.users.usersapirest.controller;

import co.com.users.usersapirest.controller.dto.UserDTO;
import co.com.users.usersapirest.usecase.UserUseCase;
import jakarta.annotation.Nullable;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class UserController {

    private final UserUseCase userUseCase;

    @GetMapping
    public ResponseEntity<?> getUsers(@RequestParam @Nullable Integer minAge, @RequestParam @Nullable Integer maxAge) {
        List<UserDTO> users = UserDTO.fromModelList(userUseCase.getUsers(minAge, maxAge));
        return ResponseEntity
                .ok()
                .body(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable String id) {
        UserDTO userDto = UserDTO.fromModel(userUseCase.getUserById(id));
        return ResponseEntity
                .ok()
                .body(userDto);
    }

    @PostMapping
    public ResponseEntity<?> createUser(@Valid @RequestBody UserDTO userDto) {
        UserDTO createdUser = UserDTO.fromModel(userUseCase.createUser(UserDTO.toModel(userDto)));
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable String id, @Valid @RequestBody UserDTO userDto) {
        UserDTO updated = UserDTO.fromModel(userUseCase.updateUser(id, UserDTO.toModel(userDto)));
        return ResponseEntity
                .ok()
                .body(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        userUseCase.deleteUser(id);
        return ResponseEntity
                .noContent()
                .build();
    }
}
