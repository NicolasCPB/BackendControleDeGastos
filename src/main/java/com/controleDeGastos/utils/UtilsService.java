package com.controleDeGastos.utils;

import com.controleDeGastos.dtos.CategoriaDTO;
import com.controleDeGastos.dtos.TipoTransacaoDTO;
import com.controleDeGastos.dtos.TransacaoDTO;
import com.controleDeGastos.models.Categoria;
import com.controleDeGastos.models.TipoTransacao;
import com.controleDeGastos.models.Transacao;

public interface UtilsService {
	
	public Transacao convertTransacaoToModel(TransacaoDTO transacao);
	public TransacaoDTO convertTransacaoToDTO(Transacao transacao);
	
	public Categoria convertCategoriaToModel(CategoriaDTO categoria);
	public CategoriaDTO convertCategoriaToDTO(Categoria categoria);
	
	public TipoTransacao convertTipoTransacaoToModel(TipoTransacaoDTO tipoTransacao);
	public TipoTransacaoDTO convertTipoTransacaoToDTO(TipoTransacao tipoTransacao);
	
}
