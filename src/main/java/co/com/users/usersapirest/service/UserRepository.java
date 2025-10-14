package co.com.users.usersapirest.service;

import co.com.users.usersapirest.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository {

    /**
     * Obtiene una lista de usuarios filtrando por edad mínima y maxima
     * @param minAge corresponde a la edad mínima para aplicar el filtro
     * @param maxAge corresponde a la edad máxima para aplicar el filtro
     * @return Lista de usuarios que cumplan con los filtros
     */
    List<User> getUsers(Integer minAge, Integer maxAge);

    /**
     *
     * @param id
     * @return
     */
    User getUserById(String id);

    /**
     *
     * @param user
     * @return
     */
    User createUser(User user);

    /**
     *
     * @param id
     * @param user
     * @return
     */
    User updateUser(String id, User user);

    /**
     *
     * @param id
     */
    void deleteUser(String id);
}
