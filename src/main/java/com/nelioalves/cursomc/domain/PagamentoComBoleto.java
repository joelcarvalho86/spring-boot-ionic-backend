package com.nelioalves.cursomc.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nelioalves.cursomc.domain.enums.EstadoPagamento;

@Entity
public class PagamentoComBoleto extends Pagamento{
	private static final long serialVersionUID = 1L;
	
	@JsonFormat(pattern = "dd/MM/yyyy hh:mm")
	private Date dataDeVencimento;
	
	@JsonFormat(pattern = "dd/MM/yyyy hh:mm")
	private Date dataPagamento;
	
	public PagamentoComBoleto() {
		
	}

	public PagamentoComBoleto(Integer id, EstadoPagamento estado, Pedido pedido, Date dataDeVencimento, Date dataPagamento) {
		super(id, estado, pedido);
		// TODO Auto-generated constructor stub
		this.dataDeVencimento = dataDeVencimento;
		this.dataPagamento = dataPagamento;
	}

	public Date getDataVencimento() {
		return dataDeVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataDeVencimento = dataVencimento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}


	
}
