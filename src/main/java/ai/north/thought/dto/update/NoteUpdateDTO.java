package ai.north.thought.dto.update;

import lombok.Data;

/**
 * Информация для обновления заметки
 */
@Data
public class NoteUpdateDTO {
    private String title;

    private String body;
}
