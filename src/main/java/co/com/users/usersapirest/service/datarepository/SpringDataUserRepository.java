package co.com.users.usersapirest.service.datarepository;

import co.com.users.usersapirest.service.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpringDataUserRepository extends JpaRepository<UserEntity, String> {

    List<UserEntity> findByAgeBetween(Integer minAge, Integer maxAge);
}
