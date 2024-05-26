package ai.north.thought.mappers;

import ai.north.thought.configs.MapperConfig;
import ai.north.thought.dto.basic.NoteDTO;
import ai.north.thought.dto.create.NoteCreateDTO;
import ai.north.thought.dto.update.NoteUpdateDTO;
import ai.north.thought.models.Note;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(config = MapperConfig.class)
public interface NoteMapper {
    NoteMapper INSTANCE = Mappers.getMapper(NoteMapper.class);

    NoteDTO toDTO(Note entity);

    Note toEntity(NoteCreateDTO payloadDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(@MappingTarget Note user, NoteUpdateDTO payloadDTO);
}

