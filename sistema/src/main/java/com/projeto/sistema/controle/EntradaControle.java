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
import com.projeto.sistema.modelos.Produto;
import com.projeto.sistema.repositorios.EntradaRepositorio;
import com.projeto.sistema.repositorios.FornecedorRepositorio;
import com.projeto.sistema.repositorios.FuncionarioRepositorio;
import com.projeto.sistema.repositorios.ItemEntradaRepositorio;
import com.projeto.sistema.repositorios.ProdutoRepositorio;

@Controller
public class EntradaControle {

    private final FuncionarioControle funcionarioControle;

	
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

    EntradaControle(FuncionarioControle funcionarioControle) {
        this.funcionarioControle = funcionarioControle;
    }
	
	@GetMapping("/cadastroEntrada")//obter o mapeamento
	public ModelAndView cadastrar(Entrada entrada, ItemEntrada itemEntrada) {
		ModelAndView mv = new ModelAndView ("/administrativo/entradas/cadastro");
		mv.addObject("entrada", entrada);	
		mv.addObject("itemEntrada", itemEntrada);
		mv.addObject("listaItemEntrada", this.listaItemEntrada);
		mv.addObject("listaFuncionarios", funcionarioRepositorio.findAll());
		mv.addObject("listaFornecedores", fornecedorRepositorio.findAll());
		mv.addObject("listaProdutos", produtoRepositorio.findAll());
		
		return mv;
	}
	
	@GetMapping("/listarEntrada")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("/administrativo/entradas/lista");
		mv.addObject("listaEntradas", entradaRepositorio.findAll());
		return mv;
	}
	
	@GetMapping("/removerEntrada/{id}")
    public ModelAndView remover(@PathVariable("id") Long id) {
        entradaRepositorio.deleteById(id);
        return listar();
    }
	
	@GetMapping("/editarEntrada/{id}")
	public ModelAndView editar(@PathVariable("id") Long id) {
		Optional<Entrada> entrada = entradaRepositorio.findById(id);
		
		this.listaItemEntrada = itemEntradaRepositorio.buscarPorEntrada(id);

		return cadastrar(entrada.get(), new ItemEntrada());
	}
	
	@PostMapping("/salvarEntrada")
	public ModelAndView salvar(String acao, Entrada entrada, ItemEntrada itemEntrada, BindingResult result) {
		if (result.hasErrors()) {
			return cadastrar(entrada, itemEntrada);
		}

		if (acao.equals("itens")) {
			this.listaItemEntrada.add(itemEntrada);
			entrada.setValorTotal(entrada.getValorTotal() + (itemEntrada.getValor() * itemEntrada.getQuantidade()));
			entrada.setQuantidadeTotal(entrada.getQuantidadeTotal() + itemEntrada.getQuantidade());

			// Continua na mesma tela com os itens adicionados
			return cadastrar(entrada, new ItemEntrada());
		}

		else if (acao.equals("salvar")) {
			// Salva entrada principal
			entradaRepositorio.saveAndFlush(entrada);

			// Salva todos os itens da entrada
			for (ItemEntrada it : listaItemEntrada) {
				it.setEntrada(entrada); // define a chave estrangeira
				itemEntradaRepositorio.saveAndFlush(it);
				// Atualiza o estoque do produto
				Optional<Produto> prod = produtoRepositorio.findById(it.getProduto().getId());
				if (prod.isPresent()) {
					Produto produto = prod.get();
					produto.setEstoque(produto.getEstoque() + it.getQuantidade());
					produto.setPrecoVenda(it.getValor());
					produto.setPrecoCusto(it.getValorCusto());
					produtoRepositorio.saveAndFlush(produto);
				}
			}

			// Limpa lista para próxima entrada
			this.listaItemEntrada = new ArrayList<>();

			// Redireciona para nova entrada
			return cadastrar(new Entrada(), new ItemEntrada());
		}

		// Fallback
		return cadastrar(new Entrada(), new ItemEntrada());
	}

	
	
}
