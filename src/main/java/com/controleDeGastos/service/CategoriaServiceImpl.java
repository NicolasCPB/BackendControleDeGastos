package com.controleDeGastos.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.controleDeGastos.dtos.CategoriaDTO;
import com.controleDeGastos.repository.CategoriaRepository;
import com.controleDeGastos.utils.UtilsService;

@Service
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	CategoriaRepository repository;
	
	@Autowired
	UtilsService utils;
	
	@CrossOrigin(allowCredentials = "*", allowedHeaders = "*", origins = "*")
	@Override
	public List<CategoriaDTO> listarCategorias() {
		return repository.findAll()
				.stream()
				.map(categoria -> {return utils.convertCategoriaToDTO(categoria);})
				.collect(Collectors.toList());
	}

}
