package com.agenciakriativa.cursomc.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.agenciakriativa.cursomc.services.DbService;
import com.agenciakriativa.cursomc.services.EmailService;
import com.agenciakriativa.cursomc.services.MockEmailService;

@Configuration
@Profile("test")
public class TestConfig {
	
	
	@Autowired
	private DbService dbService;
	
	@Bean
	public boolean instantiateDatabase() throws ParseException {
		
		dbService.instantianteTesteDatabase();
		
		return true;
	} 
	
	@Bean
	public EmailService emailService() {
		return new MockEmailService();
	}
	

}
