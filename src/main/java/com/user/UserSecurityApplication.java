package com.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Thangamudy Gurusamy
 * Date : 12/04/24
 * Package : com.user
 */
@SpringBootApplication
@EnableWebSecurity
@EnableTransactionManagement
@EnableJpaRepositories
@EntityScan
public class UserSecurityApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserSecurityApplication.class, args);
    }
}
