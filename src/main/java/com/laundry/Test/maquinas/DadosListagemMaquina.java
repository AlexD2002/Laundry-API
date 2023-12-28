package com.laundry.Test.maquinas;

public record DadosListagemMaquina(String nome) {

	public DadosListagemMaquina(Maquinas maquina) {
		this(maquina.getNome());
	}
}