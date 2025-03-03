package com.mindfire.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * Configuration class for setting up the application context with necessary beans.
 * This class contains the configuration for the {@link ModelMapper} bean used
 * for mapping objects between different types.
 */
@Configuration
public class PerformanceConfig {
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
}
