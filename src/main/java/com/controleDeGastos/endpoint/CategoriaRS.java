package com.controleDeGastos.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controleDeGastos.dtos.CategoriaDTO;
import com.controleDeGastos.service.CategoriaService;

@RestController
@RequestMapping("/categoria")
@CrossOrigin(origins = "*")
public class CategoriaRS {

	@Autowired
	CategoriaService service;
	
	@GetMapping(value = "/listarCategorias")
	public ResponseEntity<List<CategoriaDTO>> listarCategorias() {
		return new ResponseEntity<List<CategoriaDTO>>(service.listarCategorias(), HttpStatus.OK);
	}
}
