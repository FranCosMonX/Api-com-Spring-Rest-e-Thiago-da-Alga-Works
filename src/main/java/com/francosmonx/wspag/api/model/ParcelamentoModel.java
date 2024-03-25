package com.francosmonx.wspag.api.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

/**
 * modelo de representação de Parcelamento - modelar a API
 */

public class ParcelamentoModel {
	private Long id;
	
	private String nomeCliente;
	
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
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
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
	
	
}
