package co.com.users.usersapirest.usecase;

import co.com.users.usersapirest.model.User;
import co.com.users.usersapirest.service.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class UserUseCase {

    private final UserRepository userRepository;

    public List<User> getUsers(Integer minAge, Integer maxAge) {
        return userRepository.getUsers(minAge, maxAge);
    }

    public User getUserById(String id) {
        return userRepository.getUserById(id);
    }

    public User createUser(User user) {
        return userRepository.createUser(user);
    }

    public User updateUser(String id, User user) {
        return userRepository.updateUser(id, user);
    }

    public void deleteUser(String id) {
        userRepository.deleteUser(id);
    }
}
