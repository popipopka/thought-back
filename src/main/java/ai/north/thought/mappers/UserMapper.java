package ai.north.thought.mappers;

import ai.north.thought.configs.MapperConfig;
import ai.north.thought.dto.basic.UserDTO;
import ai.north.thought.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(config = MapperConfig.class)
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toEntity(UserDTO payloadDTO);

    UserDTO toDTO(User entity);
}
