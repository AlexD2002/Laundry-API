package com.laundry.Test.maquinas;

import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizarMaquina(
		@NotNull
		Long id, 
		String nome, 
		@Enumerated
		Estado estado
		
		) {
 
}
