package com.agenciakriativa.cursomc.services;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;

import com.agenciakriativa.cursomc.domain.Cliente;
import com.agenciakriativa.cursomc.domain.Pedido;

public interface EmailService {
	
	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
	
	//versão em html
	void sendOrderConfirmationHtmlEmail(Pedido obj);
	
	void sendHtmlEmail(MimeMessage msg);

	
	//recupera a senha
	void sendNewPasswordEmail(Cliente cliente, String newPass);
}
