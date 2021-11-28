package ch.mike.goetz.iaap.server.config;

import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class HibernateConfiguration {

  @Bean
  public CamelCaseToUnderscoresNamingStrategy namingStrategy() {
    return new PhysicalNamingStrategy();
  }
}
