package com.controleDeGastos;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.controleDeGastos.dtos.TransacaoDTO;
import com.controleDeGastos.service.TransacaoService;


@SpringBootTest(classes=TransacaoService.class)
class ControleDeGastosApplicationTests {

	@Autowired
	private TransacaoService transacaoService;
	
	@Test
	void testeListarTransacao() {
		List<TransacaoDTO> transacoes = transacaoService.listarTransacoes();
		
		assertThat(transacoes).isNotNull();
		assertThat(transacoes).isNotEmpty();
	}

}
