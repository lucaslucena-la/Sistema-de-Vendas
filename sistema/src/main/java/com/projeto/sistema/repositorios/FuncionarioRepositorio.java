package com.projeto.sistema.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.sistema.modelos.Funcionario;

public interface FuncionarioRepositorio extends JpaRepository<Funcionario, Long>{

}
