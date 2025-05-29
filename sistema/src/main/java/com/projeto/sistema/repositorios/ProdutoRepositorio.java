package com.projeto.sistema.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.sistema.modelos.Produto;

public interface ProdutoRepositorio extends JpaRepository<Produto, Long>{

}
