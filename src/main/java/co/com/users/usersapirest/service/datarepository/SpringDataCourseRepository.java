package co.com.users.usersapirest.service.datarepository;

import co.com.users.usersapirest.service.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataCourseRepository extends JpaRepository<CourseEntity, String> {
}
