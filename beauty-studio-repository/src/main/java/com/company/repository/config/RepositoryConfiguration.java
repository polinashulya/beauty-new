package com.company.repository.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "com.company.repository")
@EntityScan(basePackages = "com.company.entity")
@EnableTransactionManagement
public class RepositoryConfiguration {
}
