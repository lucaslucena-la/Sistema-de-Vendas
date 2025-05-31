package com.projeto.sistema.modelos;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Venda  implements Serializable {
	private static final long serialVersionUTD = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String obs;
	private Double valorTotal=0.00;
	private Double quantidadeTotal=0.00;
	private Date dataVenda = new Date();
	@ManyToOne
	private Funcionario funcionario;
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	@ManyToOne
	private Cliente cliente;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getObs() {
		return obs;
	}
	public void setObs(String obs) {
		this.obs = obs;
	}
	public Double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public Double getQuantidadeTotal() {
		return quantidadeTotal;
	}
	public void setQuantidadeTotal(Double quantidadeTotal) {
		this.quantidadeTotal = quantidadeTotal;
	}

	public Date getDataVenda() {
		return dataVenda;
	}
	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public static long getSerialversionutd() {
		return serialVersionUTD;
	}
	
	
	
}
