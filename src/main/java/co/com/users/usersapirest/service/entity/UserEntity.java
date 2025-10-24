package co.com.users.usersapirest.service.entity;

import co.com.users.usersapirest.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    @Id
    private String id;
    private String name;
    private String email;
    private Integer age;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_courses",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<CourseEntity> coursesList = new ArrayList<>();

    public static UserEntity fromModel(User user) {
        UserEntity entity = new UserEntity();
        entity.setId(user.getId());
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setAge(user.getAge());
        entity.setCoursesList(new ArrayList<>()); // Inicializar lista de cursos vacia
        return entity;
    }

    public static User toModel(UserEntity userEntity) {
        return new User(
                userEntity.getId(),
                userEntity.getName(),
                userEntity.getEmail(),
                userEntity.getAge()
        );
    }

    public static List<User> toModelList(List<UserEntity> userEntities) {
        return userEntities.stream()
                .map(UserEntity::toModel)
                .toList();
    }
}
