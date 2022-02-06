package com.agenciakriativa.cursomc.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.agenciakriativa.cursomc.domain.Cliente;
import com.agenciakriativa.cursomc.repositories.ClienteRepository;
import com.agenciakriativa.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class AuthService {
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EmailService em;
	
	private Random rd = new Random();
	
	public void sendNewPassword(String email) {
	
		Cliente cliente = clienteRepository.findByEmail(email);
		
		if(cliente == null) {
			throw new ObjectNotFoundException("Email não encontrado");
		}
		
		String newPass = newPassword();
		cliente.setSenha(pe.encode(newPass));
		
		clienteRepository.save(cliente);
		
		em.sendNewPasswordEmail(cliente, newPass);
	}

	private String newPassword() {
		char[] vet = new char[10];
		for(int i=0; i<10; i++) {
			vet[i] = randomChar();
		}
		
		return new String(vet) ;
	}

	private char randomChar() {
		int opt = rd.nextInt(3);
		if(opt == 0 ) {//gera um digito
			return (char) (rd.nextInt(10) + 48 );
		}
		else if(opt == 1) {// gera uma letra maiuscula
			return (char) (rd.nextInt(26) + 65 );
		}else {//gera uma letra minuscula
			return (char) (rd.nextInt(10) + 97 );
		}
	}

}
