package com.proyecto.pruebatecnicaback;

import com.proyecto.pruebatecnicaback.configuration.SwaggerConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(SwaggerConfiguration.class)
public class PruebaTecnicaBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(PruebaTecnicaBackApplication.class, args);
    }

}
