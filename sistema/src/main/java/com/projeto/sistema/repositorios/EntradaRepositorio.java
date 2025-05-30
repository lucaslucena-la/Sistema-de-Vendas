package com.projeto.sistema.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.sistema.modelos.ItemEntrada;

public interface EntradaRepositorio extends JpaRepository<ItemEntrada, Long>{

}
