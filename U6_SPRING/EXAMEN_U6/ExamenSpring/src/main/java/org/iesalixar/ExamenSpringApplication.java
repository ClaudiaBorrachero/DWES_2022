package org.iesalixar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;

@SpringBootApplication
public class ExamenSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamenSpringApplication.class, args);
	}
	
	//BEAN PARA HABILITAR i18n EJEMPLO=th:text="#{menu.login}"
//	@Bean
//	public MessageSource messageSource() {
//		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
//		messageSource.setBasename("locale/messages");		
//		return messageSource;
//	}

}
