package com.laundry.Test.maquinas;

public record DadosDetalhamentoMaquina(Long id, String nome, Estado estado, Boolean active, int quantidade) {

	public DadosDetalhamentoMaquina(Maquina maquina) {
		this(maquina.getId(), 
			maquina.getNome(), 
			maquina.getEstado(), 
			maquina.getActive(), 
			maquina.getQuantidade());
	}
}
