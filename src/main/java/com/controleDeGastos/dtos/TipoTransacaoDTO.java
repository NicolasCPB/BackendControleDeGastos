package com.controleDeGastos.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoTransacaoDTO {

	private Long identificador;
	
	private String nome;
	
}
