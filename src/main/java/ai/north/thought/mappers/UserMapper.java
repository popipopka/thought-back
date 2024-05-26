package ai.north.thought.mappers;

import ai.north.thought.configs.MapperConfig;
import ai.north.thought.dto.basic.UserDTO;
import ai.north.thought.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Mapper для {@link User}
 * <br><br>
 * {@link User} --> {@link UserDTO}
 * <br>
 * {@link UserDTO} --> {@link User}
 */
@Mapper(config = MapperConfig.class)
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toEntity(UserDTO userDTO);

    UserDTO toDTO(User entity);
}
