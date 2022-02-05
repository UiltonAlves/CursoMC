package com.agenciakriativa.cursomc.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.agenciakriativa.cursomc.services.DbService;

@Configuration
@Profile("test")
public class DevConfig {
	
	
	@Autowired
	private DbService dbService;
	
	@Value("${Spring.jpa.hibernate.dll.auto}")
	private String strategy;
	
	@Bean
	public boolean instantiateDatabase() throws ParseException {
		
		if(!"create".equals(strategy)) {
			return false;
		}
		
		dbService.instantianteTesteDatabase();
		return true;
	} 
	

}
