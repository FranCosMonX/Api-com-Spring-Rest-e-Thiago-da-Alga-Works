package com.francosmonx.wspag.api.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

/**
 * DTO
 */

public class ParcelamentoModel {
	private Long id;
	
	private ClienteResumoModel cliente;
	
	private String descricao;
	private BigDecimal valor_total;
	private Integer quantidade_parcelas;
	private OffsetDateTime dataCriacao;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getValor_total() {
		return valor_total;
	}
	public void setValor_total(BigDecimal valor_total) {
		this.valor_total = valor_total;
	}
	public Integer getQuantidade_parcelas() {
		return quantidade_parcelas;
	}
	public void setQuantidade_parcelas(Integer quantidade_parcelas) {
		this.quantidade_parcelas = quantidade_parcelas;
	}
	public OffsetDateTime getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(OffsetDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public ClienteResumoModel getCliente() {
		return cliente;
	}
	public void setCliente(ClienteResumoModel cliente) {
		this.cliente = cliente;
	}
	
	
}
