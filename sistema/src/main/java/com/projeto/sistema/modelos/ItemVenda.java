package com.projeto.sistema.modelos;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class ItemVenda  implements Serializable {
	private static final long serialVersionUTD = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private Double quantidade;
	private Double valor;
	private Double subTotal;
	
	@ManyToOne
	private Venda venda ;
	
	@ManyToOne
	private Produto produto;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public static long getSerialversionutd() {
		return serialVersionUTD;
	}
	
}
