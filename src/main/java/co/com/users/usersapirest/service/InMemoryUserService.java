package co.com.users.usersapirest.service;

import co.com.users.usersapirest.model.User;
import co.com.users.usersapirest.service.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("inMemoryUserService")
public class InMemoryUserService implements UserRepository {

    private List<User> users = new ArrayList<>();

    @Override
    public List<User> getUsers(Integer minAge, Integer maxAge) {
        if (minAge == null && maxAge == null) {
            return users;
        } else {
            return users.stream()
                    .filter(user -> user.getAge() >= minAge && user.getAge() <= maxAge)
                    .toList();
        }
    }

    @Override
    public User getUserById(String id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Usuario con ID " + id + " no encontrado."));
    }

    @Override
    public User createUser(User user) {
        if (users.stream().anyMatch(existingUser -> existingUser.getId().equals(user.getId()))) {
            throw new IllegalArgumentException("Ya existe un usuario con el mismo ID.");
        }
        users.add(user);
        return user;
    }

    @Override
    public User updateUser(String id, User user) {
        User existingUser = users.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Usuario con ID " + id + " no encontrado."));

        existingUser.setName(user.getName());
        existingUser.setAge(user.getAge());
        existingUser.setEmail(user.getEmail());
        return existingUser;
    }

    @Override
    public void deleteUser(String id) {
        User userToDelete = users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Usuario con ID " + id + " no encontrado."));

        users.remove(userToDelete);
    }
}
