package com.laundry.Test.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laundry.Test.maquinas.DadosCadastroMaquina;
import com.laundry.Test.maquinas.DadosListagemMaquina;
import com.laundry.Test.maquinas.MaquinaRepository;
import com.laundry.Test.maquinas.Maquinas;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/maquinas")
public class LaundryController {
	
	@Autowired
	private MaquinaRepository repository;
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid DadosCadastroMaquina dados) {
		repository.save(new Maquinas(dados));
	}
	@GetMapping
	public List<DadosListagemMaquina> listar (){
		return repository.findAll().stream().map(DadosListagemMaquina::new).toList();
	}
}
