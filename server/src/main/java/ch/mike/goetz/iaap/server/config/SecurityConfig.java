package ch.mike.goetz.iaap.server.config;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public StandardPBEStringEncryptor passwordEncryptor() {
    StandardPBEStringEncryptor passwordEncrpytor = new StandardPBEStringEncryptor();
    passwordEncrpytor.setPassword("super-007-secret!");
    return passwordEncrpytor;
  }
}
