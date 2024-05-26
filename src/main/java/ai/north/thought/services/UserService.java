package ai.north.thought.services;

import ai.north.thought.dto.basic.UserDTO;
import ai.north.thought.exceptions.EntryAlreadyCreatedException;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    UserDTO createUser(UserDTO userCreateDTO) throws EntryAlreadyCreatedException;
}
