package com.controleDeGastos.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransacaoDTO {
	
	private Long identificador;
	
	private CategoriaDTO categoria;
	
	private String descricao;
	
	private Float valor;
	
	private TipoTransacaoDTO tipoTransacao;
 
	private Date data;
		
}
