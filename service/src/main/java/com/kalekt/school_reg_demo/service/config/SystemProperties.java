package com.kalekt.school_reg_demo.service.config;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(
        prefix = "system-properties"
)
@Validated
@Data
public class SystemProperties {
    @NotEmpty
    private String studentIDPrefix;
    @NotEmpty
    private String teacherIDPrefix;
}
