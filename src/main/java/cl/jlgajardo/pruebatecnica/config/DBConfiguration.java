package cl.jlgajardo.pruebatecnica.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;


@Configuration
public class DBConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "myapp.datasources.sqlserver")
    public DataSource eafSqlServerDatasource() {
        return DataSourceBuilder.create().build();
    }

    @Bean("sqlserver")
    public JdbcTemplate eafJdbcTemplate() {
        return new JdbcTemplate(eafSqlServerDatasource());
    }
}
