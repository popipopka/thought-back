package ai.north.thought.dto.basic;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Информация о пользователе
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO {
    private String username;

    private String password;
}
