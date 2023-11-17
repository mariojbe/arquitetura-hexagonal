package br.unime.edu.arquitetura.hexagonal;

import br.unime.edu.arquitetura.hexagonal.infraestrutura.adaptadores.repositories.SpringCategoriaRepository;
import br.unime.edu.arquitetura.hexagonal.infraestrutura.adaptadores.repositories.SpringProdutoRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.data.jpa.repositry.config.EnableJpaRepositories;

// Não tive mais o erro com essa anotação
//@EnableJpaRepositories(basePackageClasses = {SpringProdutoRepository.class, SpringCategoriaRepository.class})
//@ComponentScan("br.unime.edu.arquitetura.hexagonal.infraestrutura.configuracao")
//@ComponentScan({"br.unime.edu.arquitetura.hexagonal.aplicacao.adaptatores.controllers"})
@EnableJpaRepositories(basePackages = "br.unime.edu.arquitetura.hexagonal.infraestrutura.adaptadores.repositories")
@ComponentScan(basePackages = {"br.unime.edu.arquitetura.hexagonal"})
@EntityScan("br.unime.edu.arquitetura.hexagonal.infraestrutura.adaptadores.entidades")
@SpringBootApplication
//@SpringBootApplication(scanBasePackages = {"br.unime.edu.arquitetura.hexagonal"})
public class ArquiteturaHexagonalApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArquiteturaHexagonalApplication.class, args);
    }

}
