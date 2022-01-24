package com.agenciakriativa.cursomc.domain;

import javax.persistence.Entity;

import com.agenciakriativa.cursomc.domain.enums.EstadoPagamento;

@Entity
public class PagamentoComCartao extends Pagamento{
	
	private static final long serialVersionUID = 1L;
	private Integer nuemroDeParcelas;
	
	public PagamentoComCartao () {}

	public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedido, Integer nuemroDeParcelas) {
		super(id, estado, pedido);
		this.nuemroDeParcelas = nuemroDeParcelas;
	}

	public Integer getNuemroDeParcelas() {
		return nuemroDeParcelas;
	}

	public void setNuemroDeParcelas(Integer nuemroDeParcelas) {
		this.nuemroDeParcelas = nuemroDeParcelas;
	}
	
	

}
