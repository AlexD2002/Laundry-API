package com.laundry.Test.maquinas;

public record DadosListagemMaquina(Long id, String nome, Estado estado) {

	public DadosListagemMaquina(Maquina maquina) {
		this(maquina.getId(), maquina.getNome(), maquina.getEstado());
	}
}