package com.laundry.Test.maquinas;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="laundry")
@Entity(name= "Laundry")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of= "id")

public class Maquinas {
	public Maquinas(DadosCadastroMaquina dados) {
		this.nome=dados.nome();
		this.quantidade=dados.quantidade();
		this.estado=dados.estado();
		this.site=dados.site();
		
	}
	@Id @GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private int quantidade;
	@Enumerated(EnumType.STRING)
	private Estado estado;
	private SiteCompra site;
}
