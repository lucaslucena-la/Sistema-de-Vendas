package com.projeto.sistema.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.sistema.modelos.Entrada;

public interface ItemEntradaRepositorio extends JpaRepository<Entrada, Long>{

}
