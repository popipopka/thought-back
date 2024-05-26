package ai.north.thought.configs;

import org.mapstruct.ReportingPolicy;

@org.mapstruct.MapperConfig(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface MapperConfig {
}

