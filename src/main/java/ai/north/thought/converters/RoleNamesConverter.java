package ai.north.thought.converters;

import jakarta.persistence.AttributeConverter;

public class RoleNamesConverter implements AttributeConverter<RoleNames, String> {
    @Override
    public String convertToDatabaseColumn(RoleNames roleNames) {
        return roleNames.name();
    }

    @Override
    public RoleNames convertToEntityAttribute(String s) {
        return RoleNames.fromName(s);
    }
}
