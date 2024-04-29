package com.laundry.Test.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.laundry.Test.maquinas.DadosAtualizarMaquina;
import com.laundry.Test.maquinas.DadosCadastroMaquina;
import com.laundry.Test.maquinas.DadosDetalhamentoMaquina;
import com.laundry.Test.maquinas.DadosListagemMaquina;
import com.laundry.Test.maquinas.MaquinaRepository;
import com.laundry.Test.maquinas.Maquina;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/maquinas")
public class LaundryController {

	@Autowired
	private MaquinaRepository repository;

	@PostMapping
	@Transactional
	public ResponseEntity<DadosDetalhamentoMaquina> cadastrar(@RequestBody @Valid DadosCadastroMaquina dados, UriComponentsBuilder uriBuilder) {
		var maquina = new Maquina(dados);
		repository.save(maquina);
		var uri =  uriBuilder.path("/maquinas/{id}").buildAndExpand(maquina.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new DadosDetalhamentoMaquina(maquina));
	}

	@GetMapping
	public ResponseEntity<List<DadosListagemMaquina>> listar() {
		
		var lista = repository.findAllByActiveTrue().stream().map(DadosListagemMaquina::new).toList();
		
		return ResponseEntity.ok(lista);
	}

	@PutMapping
	@Transactional
	public ResponseEntity<DadosDetalhamentoMaquina>  atualizar(@RequestBody @Valid DadosAtualizarMaquina dados) {
		var maquina = repository.getReferenceById(dados.id());
		maquina.atualizarInformacoes(dados);
		
		return ResponseEntity.ok(new DadosDetalhamentoMaquina(maquina));
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		repository.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("inativar/{id}")
	@Transactional
	public ResponseEntity<Void> inativar(@PathVariable Long id) {
		var maquina = repository.getReferenceById(id);
		maquina.inativar();
		
		return ResponseEntity.noContent().build();
	}

	@PutMapping("reativar/{id}")
	@Transactional
	public ResponseEntity<Void> reativar(@PathVariable Long id) {
		var maquina = repository.getReferenceById(id);
		maquina.reativar();
		
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DadosDetalhamentoMaquina> detalhar(@PathVariable Long id) {
		var maquina = repository.getReferenceById(id);
		
		return ResponseEntity.ok(new DadosDetalhamentoMaquina(maquina));
	}
	
}