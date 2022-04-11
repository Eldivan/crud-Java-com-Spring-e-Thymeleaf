package com.spring.crud.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.crud.model.Pessoa;
import com.spring.crud.repository.PessoaRepository;

@Controller
public class PessoaController {

	@Autowired
	PessoaRepository pessoaRepository;
	

	@GetMapping("/")
	public String inicio() {
		return "cadastro/index";
	}
	
	@GetMapping("/nova")
	public String novapessoa(@ModelAttribute("pessoa") Pessoa pessoa) {
		return "/cadastro/formulariocadastropessoas";
	}
	
	@PostMapping("/salvar")
	public String salvarpessoa(@ModelAttribute("pessoa") Pessoa pessoa) {
		pessoaRepository.save(pessoa);
		return "/cadastro/formulariocadastropessoas";
	}

	@GetMapping("/pessoascadastradas")
	public String listapessoas(Model model) {
		model.addAttribute("listaPessoas", pessoaRepository.findAll());
		return "/cadastro/index";
		
	}
	
	
		
	@GetMapping("/pessoascadastradas/{id}")
	public String alterarPessoa(@PathVariable("id") long id, Model model) {
		 
		Optional<Pessoa> pessoaOpt=	pessoaRepository.findById(id);
		if (pessoaOpt.isEmpty()) {
			throw new IllegalArgumentException("Pessoa invalida");
		}
		model.addAttribute("pessoa", pessoaOpt.get());
		
		return "/cadastro/formulariocadastropessoas";
		
	}
	 
	@GetMapping("/excluirpessoa/{id}")
	public String excluirPessoa(@PathVariable("id") long id, Model model) {
		 
		Optional<Pessoa> pessoaOpt=	pessoaRepository.findById(id);
		if (pessoaOpt.isEmpty()) {
			throw new IllegalArgumentException("Pessoa invalida");
		}
		pessoaRepository.delete(pessoaOpt.get());
		
		return "redirect:/pessoascadastradas";
		
	}
		
}
