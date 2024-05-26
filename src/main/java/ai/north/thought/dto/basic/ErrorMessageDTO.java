package ai.north.thought.dto.basic;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Сообщение об ошибке
 */
@AllArgsConstructor
@Data
public class ErrorMessageDTO {
    private String message;
}
