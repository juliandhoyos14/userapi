package co.com.users.usersapirest.controller.dto;

import co.com.users.usersapirest.model.Course;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class CourseDTO {

    private String id;
    private String name;
    private String description;
    private Integer credits;

    /**
     * Convierte de modelo de dominio a DTO.
     */
    public static CourseDTO fromModel(Course course) {
        return new CourseDTO(
                course.getId(),
                course.getName(),
                course.getDescription(),
                course.getCredits()
        );
    }

    /**
     * Convierte de DTO a modelo de dominio.
     */
    public static Course toModel(CourseDTO dto) {
        return new Course(
                dto.getId(),
                dto.getName(),
                dto.getDescription(),
                dto.getCredits()
        );
    }

    /**
     * Convierte una lista de modelos a DTOs.
     */
    public static List<CourseDTO> fromModelList(List<Course> courses) {
        return courses.stream()
                .map(CourseDTO::fromModel)
                .toList();
    }
}
