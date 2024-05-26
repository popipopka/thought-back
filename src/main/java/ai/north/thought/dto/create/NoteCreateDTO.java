package ai.north.thought.dto.create;

import lombok.Data;

/**
 * Информация для создания заметки
 */
@Data
public class NoteCreateDTO {
    private String title;

    private String body;
}
