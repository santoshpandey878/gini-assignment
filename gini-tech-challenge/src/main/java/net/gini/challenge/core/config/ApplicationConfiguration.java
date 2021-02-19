package net.gini.challenge.core.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Class responsible to handle application level configuration
 *
 */
@Configuration
public class ApplicationConfiguration {

	/**
	 * ModelMapper bean used for DTO conversion
	 * @return
	 */
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	/**
	 * RestTemplate bean used to call external client
	 * @return
	 */
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
