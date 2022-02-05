package com.agenciakriativa.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.agenciakriativa.cursomc.domain.Pedido;

public interface EmailService {
	
	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);

}
