package co.com.users.usersapirest.service;

import co.com.users.usersapirest.model.User;
import co.com.users.usersapirest.service.datarepository.SpringDataUserRepository;
import co.com.users.usersapirest.service.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import co.com.users.usersapirest.service.entity.UserEntity;

import java.util.List;

@Service("mySQLUserManager")
@AllArgsConstructor
public class MySQLUserManager implements UserRepository {

    private final SpringDataUserRepository userRepo;

    @Override
    public List<User> getUsers(Integer minAge, Integer maxAge) {
        if (minAge != null && maxAge != null) {
            return UserEntity.toModelList(userRepo.findByAgeBetween(minAge, maxAge));
        }
        return UserEntity.toModelList(userRepo.findAll());
    }

    @Override
    public User getUserById(String id) {
        return UserEntity.toModel(
                userRepo.findById(id)
                        .orElseThrow(() -> new IllegalArgumentException("User not found with id " + id))
        );
    }

    @Override
    public User createUser(User user) {
        if (userRepo.existsById(user.getId())) {
            throw new IllegalArgumentException(
                    "A user with the same ID already exists.");
        }
        userRepo.save(UserEntity.fromModel(user));
        return user;
    }

    @Override
    public User updateUser(String id, User user) {
        // Buscar el usuario existente en la base de datos
        UserEntity existingUser = userRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuario con ID " + id + " no encontrado."));
        // Actualizar los campos del usuario existente
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser.setAge(user.getAge());
        // Guardar los cambios en la base de datos
        UserEntity updatedEntity = userRepo.save(existingUser);
        // Convertir la entidad a modelo y retornar
        return UserEntity.toModel(updatedEntity);
    }

    @Override
    public void deleteUser(String id) {
        if (!userRepo.existsById(id)) {
            throw new IllegalArgumentException("Usuario con ID " + id + " no encontrado.");
        }
        userRepo.deleteById(id);
    }
}
