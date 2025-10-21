package co.com.users.usersapirest.controller.dto;

import co.com.users.usersapirest.model.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class UserDTO {

    @NotNull(message = "Id is required")
    private String id;

    @NotNull(message = "Name is required")
    private String name;

    @NotNull(message = "Email is required")
    @Email(message = "The email is not valid")
    private String email;

    @NotNull(message = "Age is required")
    @Min(value = 10, message = "The age cannot be less than 10")
    @Max(value = 50, message = "The age cannot be greater than 50")
    private Integer age;

    public static User toModel(UserDTO userDTO) {
        return new User(
                userDTO.getId(),
                userDTO.getName(),
                userDTO.getEmail(),
                userDTO.getAge()
        );
    }

    public static UserDTO fromModel(User user) {
        return new UserDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getAge()
        );
    }

    public static List<UserDTO> fromModelList(List<User> users) {
        return users.stream()
                .map(UserDTO::fromModel)
                .toList();
    }
}
