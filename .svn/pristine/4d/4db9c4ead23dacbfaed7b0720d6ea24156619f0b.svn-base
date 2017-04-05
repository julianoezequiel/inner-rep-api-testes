/**
 *******************************************************************************
 * Exemplo Comunicação HTTP
 *
 * Desenvolvido em Java 1.8
 *
 * Topdata Sistemas de Automação Ltda.
 * ******************************************************************************
 */
package com.api;

import java.text.SimpleDateFormat;

import javax.servlet.MultipartConfigElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.api.rep.filter.DebugFilter;
import com.api.rep.filter.TokenFilter;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Classe Principal
 * 
 * @author juliano.ezequiel
 *
 */
@SpringBootApplication
@EnableScheduling
public class RepApiApplication extends SpringBootServletInitializer {

	@Autowired
	private TokenFilter tokenFilter;

	// filtro para debug,
	@Bean
	public FilterRegistrationBean filtroDebug() {
		FilterRegistrationBean bean = new FilterRegistrationBean();
		bean.setFilter(new DebugFilter());
		bean.addUrlPatterns("/*");
		return bean;
	}

	// filtro para as requisicoes restritas
	@Bean
	public FilterRegistrationBean filtroJwt() {
		FilterRegistrationBean bean = new FilterRegistrationBean();
		bean.setFilter(tokenFilter);
		bean.addUrlPatterns("/restrict/*");

		return bean;
	}

	// configurar o mapper para não enviar \r\n no json
	@Bean
	public Jackson2ObjectMapperBuilder jacksonBuilder() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
		Jackson2ObjectMapperBuilder b = new Jackson2ObjectMapperBuilder();
		b.indentOutput(false).dateFormat(new SimpleDateFormat("yyyy-MM-dd"));
		b.failOnUnknownProperties(false);
		b.configure(mapper);
		return b;
	}

	// configura o multipart
	@Bean
	MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		factory.setMaxFileSize("10MB");
		factory.setMaxRequestSize("10MB");
		factory.setLocation(System.getProperty("java.io.tmpdir"));
		return factory.createMultipartConfig();
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		// Customize the application or call application.sources(...) to add
		// sources
		// Since our example is itself a @Configuration class (via
		// @SpringBootApplication)
		// we actually don't need to override this method.
		return application.sources(RepApiApplication.class);
	}

	// Start inicial do app
	public static void main(String[] args) {
		SpringApplication.run(RepApiApplication.class, args);
	}
}
