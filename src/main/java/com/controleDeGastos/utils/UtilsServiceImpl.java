package com.controleDeGastos.utils;

import org.springframework.stereotype.Service;

import com.controleDeGastos.dtos.CategoriaDTO;
import com.controleDeGastos.dtos.TipoTransacaoDTO;
import com.controleDeGastos.dtos.TransacaoDTO;
import com.controleDeGastos.models.Categoria;
import com.controleDeGastos.models.TipoTransacao;
import com.controleDeGastos.models.Transacao;

@Service
public class UtilsServiceImpl implements UtilsService {

	@Override
	public Transacao convertTransacaoToModel(TransacaoDTO transacao) {
		Transacao t = new Transacao();
		t.setCategoria(convertCategoriaToModel(transacao.getCategoria()));
		t.setTipoTransacao(convertTipoTransacaoToModel(transacao.getTipoTransacao()));
		t.setData(transacao.getData());
		t.setDescricao(transacao.getDescricao());
		t.setValor(transacao.getValor());
		
		return t;
	}

	@Override
	public TransacaoDTO convertTransacaoToDTO(Transacao transacao) {
		TransacaoDTO t = new TransacaoDTO();
		t.setIdentificador(transacao.getIdentificador());
		t.setCategoria(convertCategoriaToDTO(transacao.getCategoria()));
		t.setTipoTransacao(convertTipoTransacaoToDTO(transacao.getTipoTransacao()));
		t.setData(transacao.getData());
		t.setDescricao(transacao.getDescricao());
		t.setValor(transacao.getValor());
		
		return t;
	}

	@Override
	public Categoria convertCategoriaToModel(CategoriaDTO categoria) {
		Categoria c = new Categoria();
		c.setNome(categoria.getNome());
		
		return c;
	}

	@Override
	public CategoriaDTO convertCategoriaToDTO(Categoria categoria) {
		CategoriaDTO c = new CategoriaDTO();
		c.setIdentificador(categoria.getIdentificador());
		c.setNome(categoria.getNome());
		
		return c;
	}

	@Override
	public TipoTransacao convertTipoTransacaoToModel(TipoTransacaoDTO tipoTransacao) {
		TipoTransacao tp = new TipoTransacao();
		tp.setNome(tipoTransacao.getNome());
		
		return tp;
	}

	@Override
	public TipoTransacaoDTO convertTipoTransacaoToDTO(TipoTransacao tipoTransacao) {
		TipoTransacaoDTO tp = new TipoTransacaoDTO();
		tp.setIdentificador(tipoTransacao.getIdentificador());
		tp.setNome(tipoTransacao.getNome());
		
		return tp;
	}

}
