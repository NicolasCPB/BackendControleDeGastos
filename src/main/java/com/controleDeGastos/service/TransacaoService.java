package com.controleDeGastos.service;

import java.util.List;

import com.controleDeGastos.dtos.FiltroDTO;
import com.controleDeGastos.dtos.RetornoEnvioDTO;
import com.controleDeGastos.dtos.TransacaoDTO;

public interface TransacaoService {

	public RetornoEnvioDTO cadastrarTransacao(TransacaoDTO transacao) throws Exception;
	
	public List<TransacaoDTO> listarTransacoesPorFiltro(FiltroDTO filtro);
	
	public List<TransacaoDTO> listarTransacoes();
	
	public RetornoEnvioDTO excluirTransacao(Long identificador);
	
	public RetornoEnvioDTO editarTransacao(Long identificador, TransacaoDTO transacao);
}
