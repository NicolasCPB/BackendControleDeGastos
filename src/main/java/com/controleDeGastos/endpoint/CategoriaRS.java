package com.controleDeGastos.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.controleDeGastos.dtos.CategoriaDTO;
import com.controleDeGastos.dtos.RetornoEnvioDTO;
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
	
	@PostMapping(value = "/salvarCategoria", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public ResponseEntity<RetornoEnvioDTO> cadastrarTransacao(@RequestBody CategoriaDTO categoriaDTO) throws Exception {
		return new ResponseEntity<RetornoEnvioDTO>(service.cadastrarCategoria(categoriaDTO), HttpStatus.CREATED);
	}
}
