package com.laundry.Test.maquinas;

import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;


public record DadosCadastroMaquina(
		@NotBlank
		String nome,
		@Enumerated
		Estado estado,
		
		int quantidade
		) {

}
