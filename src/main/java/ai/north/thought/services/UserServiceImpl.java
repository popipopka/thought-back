package ai.north.thought.services;

import ai.north.thought.converters.RoleNames;
import ai.north.thought.dto.basic.UserDTO;
import ai.north.thought.exceptions.EntryAlreadyCreatedException;
import ai.north.thought.mappers.UserMapper;
import ai.north.thought.models.User;
import ai.north.thought.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    private final MessageSource messageSource;
    private final PasswordEncoder passwordEncoder;

    private final UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(messageSource
                        .getMessage("error.notfound-username.user", new Object[]{username}, Locale.getDefault())));
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) throws EntryAlreadyCreatedException {
        if (userRepository.existsByUsername(userDTO.getUsername())) {
            throw new EntryAlreadyCreatedException(messageSource
                    .getMessage("error.already-created.user", new Object[0], Locale.getDefault()));
        }

        User user = userMapper.toEntity(userDTO);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.addRole(RoleNames.USER);

        userRepository.save(user);

        return userDTO;
    }

    @EventListener(value = ContextRefreshedEvent.class)
    private void createAdminUserWhenApplicationStart() {
        final String username = "admin";
        final String password = "admin";

        if (userRepository.existsByUsername(username)) {
            return;
        }

        User admin = new User();

        admin.setUsername(username);
        admin.setPassword(passwordEncoder.encode(password));

        admin.addRole(RoleNames.ADMIN);

        userRepository.save(admin);
    }
}
