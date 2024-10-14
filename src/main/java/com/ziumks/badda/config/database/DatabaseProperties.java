package com.ziumks.badda.config.database;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

/**
 * 데이터베이스별 시스템 프로퍼티 값 주입
 *
 * @author  이상민
 * @since   2024.05.21 16:30
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Valid
@ConfigurationProperties(prefix = "db")
@Configuration
public class DatabaseProperties {

    private Base base;

    private Target target;

    @Data
    public static class Base{

        @NotBlank(message = "{valid.props.not-blank}")
        private String driver;

        @NotBlank(message = "{valid.props.not-blank}")
        private String dialect;

        @NotBlank(message = "{valid.props.not-blank}")
        private String url;

        @NotBlank(message = "{valid.props.not-blank}")
        private String username;

        @NotBlank(message = "{valid.props.not-blank}")
        private String password;

        private String schema;

        private String showSql = "false";

        private String ddlAuto = "none";

        private String maxPoolSize = "5";

    }

    @Data
    public static class Target {

        private String driver;
        private String dialect;
        private String url;
        private String username;
        private String password;
        private String schema;
        private String showSql;
        private String ddlAuto;
        private String maxPoolSize;

    }

}
