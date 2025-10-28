package co.com.users.usersapirest.service.entity;

import co.com.users.usersapirest.model.Course;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseEntity {

    @Id
    private String id;
    private String name;
    private String description;
    private Integer credits;
    @ManyToMany(mappedBy = "coursesList")
    private List<UserEntity> users = new ArrayList<>();

    public static Course toModel(CourseEntity courseEntity) {
        return new Course(
                courseEntity.getId(),
                courseEntity.getName(),
                courseEntity.getDescription(),
                courseEntity.getCredits()
        );
    }

    public static List<Course> toModelList(List<CourseEntity> courseEntities) {
        return courseEntities.stream()
                .map(CourseEntity::toModel)
                .toList();
    }
}
