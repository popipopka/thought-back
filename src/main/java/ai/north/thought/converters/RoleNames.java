package ai.north.thought.converters;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RoleNames {
    ADMIN("ROLE_ADMIN"),
    USER("ROLE_USER");

    private final String authority;

    public static RoleNames fromName(String name) {
        for (RoleNames role : values()) {
            if (role.name().equals(name)) {
                return role;
            }
        }
        throw new IllegalArgumentException("Соответствующая роль не найдена для: " + name);
    }
}
