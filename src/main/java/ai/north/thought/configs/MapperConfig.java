package ai.north.thought.configs;

import org.mapstruct.ReportingPolicy;

/**
 * Конфигурация для mappers
 */
@org.mapstruct.MapperConfig(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface MapperConfig {
}

