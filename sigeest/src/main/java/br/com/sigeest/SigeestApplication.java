package br.com.sigeest;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;

@EnableJpaRepositories(basePackages = "br.com.sigeest.repository")
@SpringBootApplication
public class SigeestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SigeestApplication.class, args);
	}
	
	@Bean
	public Java8TimeDialect java8TimeDialect() {
		return new Java8TimeDialect();
	}

	@Bean
	public LocaleResolver localeResolver() {
		return new FixedLocaleResolver(new Locale("pt", "BR"));
	}
}
