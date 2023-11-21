package com.controleDeGastos.service;

import java.util.List;

import com.controleDeGastos.dtos.CategoriaDTO;
import com.controleDeGastos.dtos.RetornoEnvioDTO;

public interface CategoriaService {

	public List<CategoriaDTO> listarCategorias();
	
	public RetornoEnvioDTO cadastrarCategoria(CategoriaDTO categoria) throws Exception;
}
