package com.projeto.sistema.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.sistema.modelos.Cliente;

public interface ClienteRepositorio extends JpaRepository<Cliente, Long>{

}
