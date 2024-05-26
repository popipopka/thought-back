package ai.north.thought.dto.basic;

import lombok.Data;

/**
 * Информация о заметке
 */
@Data
public class NoteDTO {
    private int id;

    private String title;

    private String body;
}
