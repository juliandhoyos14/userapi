package co.com.users.usersapirest.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class User {

    private String id;
    private String name;
    private String email;
    private Integer age;
}
