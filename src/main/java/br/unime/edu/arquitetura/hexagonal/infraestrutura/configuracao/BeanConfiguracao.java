package br.unime.edu.arquitetura.hexagonal.infraestrutura.configuracao;

import br.unime.edu.arquitetura.hexagonal.dominio.adaptadores.services.CategoriaServiceImp;
import br.unime.edu.arquitetura.hexagonal.dominio.adaptadores.services.PedidoServiceImp;
import br.unime.edu.arquitetura.hexagonal.dominio.portas.interfaces.CategoriaServicePort;
import br.unime.edu.arquitetura.hexagonal.dominio.portas.interfaces.PedidoServicePort;
import br.unime.edu.arquitetura.hexagonal.dominio.portas.interfaces.ProdutoServicePort;
import br.unime.edu.arquitetura.hexagonal.dominio.portas.repositories.CategoriaRepositoryPort;
import br.unime.edu.arquitetura.hexagonal.dominio.portas.repositories.PedidoRepositoryPort;
import br.unime.edu.arquitetura.hexagonal.dominio.portas.repositories.ProdutoRepositoryPort;
//import jakarta.persistence.EntityManagerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = "br.unime.edu.arquitetura.hexagonal.infraestrutura.adaptadores.repositories")
public class BeanConfiguracao {
    @Bean
    public DataSource dataSource() {
        // Configure and return the DataSource here
        // Example configuration for H2 in-memory database
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .build();
    }

    @Bean
    public EntityManagerFactory entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource);
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        // Set the package to scan for JPA entities
        entityManagerFactoryBean.setPackagesToScan("br.unime.edu.arquitetura.hexagonal.infraestrutura.adaptadores.entidades");
        entityManagerFactoryBean.afterPropertiesSet();
        return entityManagerFactoryBean.getObject();
    }

    @Bean
    PedidoServicePort pedidoService(PedidoRepositoryPort pedidoRepositoryPort) {
        return new PedidoServiceImp(pedidoRepositoryPort);
    }

    @Bean
    CategoriaServicePort categoriaService(CategoriaRepositoryPort categoriaRepositoryPort) {
        return new CategoriaServiceImp(categoriaRepositoryPort);
    }

}