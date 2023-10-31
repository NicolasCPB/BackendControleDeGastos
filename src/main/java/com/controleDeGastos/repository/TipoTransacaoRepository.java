package com.controleDeGastos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.controleDeGastos.models.TipoTransacao;

public interface TipoTransacaoRepository extends JpaRepository<TipoTransacao, Long>{

	public TipoTransacao findByNome(String nome);
}
