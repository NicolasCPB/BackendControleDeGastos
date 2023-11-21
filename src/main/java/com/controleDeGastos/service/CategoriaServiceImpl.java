package com.controleDeGastos.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controleDeGastos.dtos.CategoriaDTO;
import com.controleDeGastos.dtos.RetornoEnvioDTO;
import com.controleDeGastos.models.Categoria;
import com.controleDeGastos.repository.CategoriaRepository;
import com.controleDeGastos.utils.ConversorUtil;

@Service
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	CategoriaRepository repository;
	
	@Override
	public List<CategoriaDTO> listarCategorias() {
		return repository.findAll()
				.stream()
				.map(categoria -> {return ConversorUtil.convertCategoriaToDTO(categoria);})
				.collect(Collectors.toList());
	}
	
	@Override
	public RetornoEnvioDTO cadastrarCategoria(CategoriaDTO categoriaDTO) throws Exception {
		RetornoEnvioDTO retorno = new RetornoEnvioDTO();
		Categoria categoriaModel = ConversorUtil.convertCategoriaToModel(categoriaDTO);
		
		try {			
			repository.save(categoriaModel);
			retorno.setMensagem("Categoria cadastrada com sucesso.");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Erro ao cadastrar categoria");
		}
		
		return retorno;
	}

}
