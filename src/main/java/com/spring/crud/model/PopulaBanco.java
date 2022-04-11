package com.spring.crud.model;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.spring.crud.repository.PessoaRepository;

@Transactional
@Component
public class PopulaBanco implements CommandLineRunner {
 
	@Autowired
	PessoaRepository pessoaRepository;
	

	@Override
	public void run(String... args) throws Exception {
		/*	
		Pessoa p1 = new Pessoa();
		p1.setNome("Maria");
		p1.setCpf("123 456 789 10");
		p1.setDataNascimento(LocalDate.of(2001, 02, 01));
		p1.setEmail("maria@maria");
		p1.setTelefone("61 9 9999 8888");
				
		Pessoa p2 = new Pessoa();
		p2.setNome("João");
		p2.setCpf("123 456 789 11");
		p2.setDataNascimento(LocalDate.of(1990, 02, 10));
		p2.setEmail("joao@joao");
		p2.setTelefone("61 9 8888 7777");
		
		pessoaRepository.save(p1);
		pessoaRepository.save(p2);
	    */
	}
  
}
