package cl.jlgajardo.pruebatecnica;

import cl.jlgajardo.pruebatecnica.config.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class ApiPruebaTecnica {
    public static void main(String[] args) {
        SpringApplication.run(ApiPruebaTecnica.class, args);
    }
}
