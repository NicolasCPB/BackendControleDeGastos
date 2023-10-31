package com.controleDeGastos.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.controleDeGastos.dtos.FiltroDTO;
import com.controleDeGastos.dtos.RetornoEnvioDTO;
import com.controleDeGastos.dtos.TransacaoDTO;
import com.controleDeGastos.service.TransacaoService;

@RestController
@RequestMapping("/transacao")
@CrossOrigin(origins = "*")
public class TransacaoRS {

	@Autowired
	TransacaoService service;
	
	@PostMapping(value = "/salvarTransacao", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public ResponseEntity<RetornoEnvioDTO> cadastrarTransacao(@RequestBody TransacaoDTO transacao) throws Exception {
		return new ResponseEntity<RetornoEnvioDTO>(service.cadastrarTransacao(transacao), HttpStatus.CREATED);
	}
	
	@PostMapping(value = "/listarTransacoesPorFiltro", produces = "application/json; charset=UTF-8")
	public ResponseEntity<List<TransacaoDTO>> listarTransacoesFiltro(@RequestBody FiltroDTO filtro) {
		return new ResponseEntity<List<TransacaoDTO>>(service.listarTransacoesPorFiltro(filtro), HttpStatus.OK);
	}
	
	@GetMapping(value = "/listarTransacoes")
	public ResponseEntity<List<TransacaoDTO>> listarTransacoes() {
		return new ResponseEntity<List<TransacaoDTO>>(service.listarTransacoes(), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/excluirTransacao/{identificador}", produces = "application/json; charset=UTF-8")
	public ResponseEntity<RetornoEnvioDTO> excluirTransacao(@PathVariable Long identificador) {
		return new ResponseEntity<RetornoEnvioDTO>(service.excluirTransacao(identificador), HttpStatus.OK);
	}
	
	@PutMapping(value = "/editarTransacao/{identificador}", produces = "application/json; charset=UTF-8")
	public ResponseEntity<RetornoEnvioDTO> editarTransacao(@PathVariable Long identificador, @RequestBody TransacaoDTO transacao) {
		return new ResponseEntity<RetornoEnvioDTO>(service.editarTransacao(identificador, transacao), HttpStatus.OK);
	}
	
}
