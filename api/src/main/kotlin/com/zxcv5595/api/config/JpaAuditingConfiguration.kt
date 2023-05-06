package com.zxcv5595.api.config

import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
@Configuration
@EnableJpaAuditing
@EnableJpaRepositories(basePackages = ["com.zxcv5595.domain"])
class JpaAuditingConfiguration {
}