package com.digdes.pcs.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.digdes.pcs")
@EnableJpaRepositories("com.digdes.pcs.persistence.repository")
@EntityScan(basePackages = "com.digdes.pcs.persistence.model")
public class ProjectControlSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProjectControlSystemApplication.class, args);

    }

}
