package com.projeto.sistema.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.projeto.sistema.modelos.ItemVenda;

public interface ItemVendaRepositorio extends JpaRepository<ItemVenda, Long>{
	@Query("SELECT e FROM ItemVenda e Where e.venda.id = ?1")
	List<ItemVenda>buscarPorVenda(long id);
}


