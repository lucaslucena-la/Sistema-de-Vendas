package com.projeto.sistema.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.sistema.modelos.Cidade;

public interface CidadeRepositorio extends JpaRepository<Cidade, Long>{

}
