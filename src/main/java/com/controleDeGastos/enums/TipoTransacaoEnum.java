package com.controleDeGastos.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TipoTransacaoEnum {

	ENTRADA("Entrada"),
	SAIDA("Saída");
	
	private String nome;
}
