package ai.north.thought.services;

import ai.north.thought.dto.basic.UserDTO;
import ai.north.thought.exceptions.EntryAlreadyCreatedException;
import ai.north.thought.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Сервис для сущности {@link User}
 */
public interface UserService extends UserDetailsService {
    /**
     * Создание пользователя
     * @param userCreateDTO данные для создания
     * @return созданный пользователь
     * @throws EntryAlreadyCreatedException пользователь уже создан
     */
    UserDTO createUser(UserDTO userCreateDTO) throws EntryAlreadyCreatedException;
}
