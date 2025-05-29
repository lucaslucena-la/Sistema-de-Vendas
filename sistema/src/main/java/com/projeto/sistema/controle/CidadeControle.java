package com.projeto.sistema.controle;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.projeto.sistema.modelos.Cidade;
import com.projeto.sistema.repositorios.CidadeRepositorio;
import com.projeto.sistema.repositorios.EstadoRepositorio;

@Controller
public class CidadeControle {

	
	@Autowired
	private CidadeRepositorio cidadeRepositorio;
	
	@Autowired
	private EstadoRepositorio estadoRepositorio;
	
	@GetMapping("/cadastroCidade")//obter o mapeamento
	public ModelAndView cadastrar(Cidade cidade) {
		ModelAndView mv = new ModelAndView ("/administrativo/cidades/cadastro");
		mv.addObject("cidade", cidade);	
		mv.addObject("listaEstados", estadoRepositorio.findAll());
		return mv;
	}
	
	@GetMapping("/listarCidade")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("/administrativo/cidades/lista");
		mv.addObject("listaCidades", cidadeRepositorio.findAll());
		return mv;
	}
	
	@GetMapping("/removerCidade/{id}")
    public ModelAndView remover(@PathVariable("id") Long id) {
        cidadeRepositorio.deleteById(id);
        return listar();
    }
	
	@GetMapping("/editarCidade/{id}")
	public ModelAndView editar(@PathVariable("id") Long id) {
		Optional<Cidade> cidade = cidadeRepositorio.findById(id);
		return cadastrar(cidade.get());
	}
	
	@PostMapping("/salvarCidade")
	public ModelAndView salvar(Cidade cidade, BindingResult result) {
		if(result.hasErrors()) {
			return cadastrar(cidade);
		}
		cidadeRepositorio.saveAndFlush(cidade);
		return cadastrar(new Cidade());
	}
}
