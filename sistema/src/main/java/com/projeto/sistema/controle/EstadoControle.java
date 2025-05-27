package com.projeto.sistema.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.projeto.sistema.modelos.Estado;
import com.projeto.sistema.repositorios.EstadoRepositorio;

@Controller
public class EstadoControle {

	
	@Autowired
	private EstadoRepositorio estadoRepositorio;
	
	@GetMapping("/cadastroEstado")//obter o mapeamento
	public ModelAndView cadastrar(Estado estado) {
		ModelAndView mView = new ModelAndView ("/administrativo/estados/cadastro");
		mView.addObject("estado", estado);	
		return mView;
	}
	
	@PostMapping("/salvarEstado")
	public ModelAndView salvar(Estado estado, BindingResult result) {
		if(result.hasErrors()) {
			return cadastrar(estado);
		}
		estadoRepositorio.saveAndFlush(estado);
		return cadastrar(new Estado());
	}
}
