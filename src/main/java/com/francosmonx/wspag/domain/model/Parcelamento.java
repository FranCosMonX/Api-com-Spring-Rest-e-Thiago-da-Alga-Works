package com.francosmonx.wspag.domain.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Objects;

import com.francosmonx.wspag.domain.validation.ValidationGroups;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.groups.ConvertGroup;
import jakarta.validation.groups.Default;

@Entity
public class Parcelamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Valid
	@ConvertGroup(from = Default.class, to = ValidationGroups.clienteID.class)
	@NotNull
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	@NotBlank
	private String descricao;
	@NotNull
	@Positive
	private BigDecimal valor_total;
	@NotNull
	@Positive
	@Max(12)
	private Integer quantidade_parcelas;
	private OffsetDateTime dataCriacao;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descrição) {
		this.descricao = descrição;
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
	public void setQuantidade_parcelas(Integer quantidade_de_parcelas) {
		this.quantidade_parcelas = quantidade_de_parcelas;
	}
	public OffsetDateTime getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(OffsetDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Parcelamento other = (Parcelamento) obj;
		return Objects.equals(id, other.id);
	}
	
}
