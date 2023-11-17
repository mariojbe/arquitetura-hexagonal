package br.unime.edu.arquitetura.hexagonal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "br.unime.edu.arquitetura.hexagonal.infraestrutura.adaptadores.repositories")
@ComponentScan(basePackages = {"br.unime.edu.arquitetura.hexagonal"})
@EntityScan("br.unime.edu.arquitetura.hexagonal.infraestrutura.adaptadores.entidades")
@SpringBootApplication
public class ArquiteturaHexagonalApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArquiteturaHexagonalApplication.class, args);
    }

}
