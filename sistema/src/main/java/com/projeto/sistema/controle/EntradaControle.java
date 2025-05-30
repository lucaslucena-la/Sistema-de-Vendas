package com.projeto.sistema.controle;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.projeto.sistema.modelos.Entrada;
import com.projeto.sistema.modelos.ItemEntrada;
import com.projeto.sistema.repositorios.EntradaRepositorio;
import com.projeto.sistema.repositorios.FornecedorRepositorio;
import com.projeto.sistema.repositorios.FuncionarioRepositorio;
import com.projeto.sistema.repositorios.ItemEntradaRepositorio;
import com.projeto.sistema.repositorios.ProdutoRepositorio;

@Controller
public class EntradaControle {

	
	@Autowired
	private EntradaRepositorio entradaRepositorio;
	
	@Autowired
	private ItemEntradaRepositorio itemEntradaRepositorio;
	
	@Autowired
	private ProdutoRepositorio produtoRepositorio;
	
	@Autowired 
	private FuncionarioRepositorio funcionarioRepositorio;
	
	@Autowired
	private FornecedorRepositorio fornecedorRepositorio;
	
	private List<ItemEntrada> listaItemEntrada = new ArrayList<ItemEntrada>();
	
	@GetMapping("/cadastroEntrada")//obter o mapeamento
	public ModelAndView cadastrar(Entrada entrada, ItemEntrada itemEntrada) {
		ModelAndView mv = new ModelAndView ("/administrativo/entradas/cadastro");
		mv.addObject("entrada", entrada);	
		mv.addObject("itemEntrada", itemEntrada);
		mv.addObject("listaItemEntrada", this.listaItemEntrada);
		mv.addObject("listaFuncionarios", funcionarioRepositorio.findAll());
		mv.addObject("listaFornecedores", fornecedorRepositorio.findAll());
		mv.addObject("listaPodutos", produtoRepositorio.findAll());
		
		return mv;
	}
	
	@GetMapping("/listarEntrada")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("/administrativo/entradas/lista");
		mv.addObject("listaEntradas", entradaRepositorio.findAll());
		return mv;
	}
	
//	@GetMapping("/removerEntrada/{id}")
//    public ModelAndView remover(@PathVariable("id") Long id) {
//        entradaRepositorio.deleteById(id);
//        return listar();
//    }
	
//	@GetMapping("/editarEntrada/{id}")
//	public ModelAndView editar(@PathVariable("id") Long id) {
//		Optional<Entrada> entrada = entradaRepositorio.findById(id);
//		return cadastrar(entrada.get());
//	}
//	
	@PostMapping("/salvarEntrada")
	public ModelAndView salvar(Entrada entrada, ItemEntrada itemEntrada, BindingResult result) {
		if(result.hasErrors()) {
			return cadastrar(entrada, itemEntrada);
		}
		entradaRepositorio.saveAndFlush(entrada);
		return cadastrar(new Entrada(), new ItemEntrada());
	}

	public List<ItemEntrada> getListaItemEntrada() {
		return listaItemEntrada;
	}

	public void setListaItemEntrada(List<ItemEntrada> listaItemEntrada) {
		this.listaItemEntrada = listaItemEntrada;
	}
	
	
}
