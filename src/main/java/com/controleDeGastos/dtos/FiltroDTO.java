package com.controleDeGastos.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FiltroDTO {
	private CategoriaDTO categoria;
	
	private String descricao;

	private Float valor;
	
	private TipoTransacaoDTO tipoTransacao;
	
	private Date dataInicial;
	
	private Date dataFinal;
}
