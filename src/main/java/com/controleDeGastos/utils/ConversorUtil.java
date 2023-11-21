package com.controleDeGastos.utils;

import com.controleDeGastos.dtos.CategoriaDTO;
import com.controleDeGastos.dtos.TipoTransacaoDTO;
import com.controleDeGastos.dtos.TransacaoDTO;
import com.controleDeGastos.models.Categoria;
import com.controleDeGastos.models.TipoTransacao;
import com.controleDeGastos.models.Transacao;
import com.fasterxml.jackson.databind.ObjectMapper;

public interface ConversorUtil {

	static ObjectMapper mapper = new ObjectMapper();
	
	public static Transacao convertTransacaoToModel(TransacaoDTO transacao) {
		return mapper.convertValue(transacao, Transacao.class);
	}

	public static TransacaoDTO convertTransacaoToDTO(Transacao transacao) {
		return mapper.convertValue(transacao, TransacaoDTO.class);
	}

	public static Categoria convertCategoriaToModel(CategoriaDTO categoria) {
		return mapper.convertValue(categoria, Categoria.class);
	}

	public static CategoriaDTO convertCategoriaToDTO(Categoria categoria) {
		return mapper.convertValue(categoria, CategoriaDTO.class);
	}

	public static TipoTransacao convertTipoTransacaoToModel(TipoTransacaoDTO tipoTransacao) {
		return mapper.convertValue(tipoTransacao, TipoTransacao.class);
	}

	public static TipoTransacaoDTO convertTipoTransacaoToDTO(TipoTransacao tipoTransacao) {
		return mapper.convertValue(tipoTransacao, TipoTransacaoDTO.class);
	}

}
