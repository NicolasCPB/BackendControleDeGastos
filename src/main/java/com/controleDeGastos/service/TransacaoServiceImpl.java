package com.controleDeGastos.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controleDeGastos.dtos.FiltroDTO;
import com.controleDeGastos.dtos.RetornoEnvioDTO;
import com.controleDeGastos.dtos.TransacaoDTO;
import com.controleDeGastos.models.Categoria;
import com.controleDeGastos.models.TipoTransacao;
import com.controleDeGastos.models.Transacao;
import com.controleDeGastos.repository.CategoriaRepository;
import com.controleDeGastos.repository.TipoTransacaoRepository;
import com.controleDeGastos.repository.TransacaoRepository;
import com.controleDeGastos.utils.UtilsService;

@Service
public class TransacaoServiceImpl implements TransacaoService {

	@Autowired
	TransacaoRepository repository;
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Autowired
	TipoTransacaoRepository tipoTransacaoRepository;
	
	@Autowired
	UtilsService utils;
	
	@Override
	public RetornoEnvioDTO cadastrarTransacao(TransacaoDTO transacao) throws Exception {
		RetornoEnvioDTO retorno = new RetornoEnvioDTO();
		Transacao transacaoModel = utils.convertTransacaoToModel(transacao);
		Categoria categoria = categoriaRepository.findByNome(transacao.getCategoria().getNome());
		TipoTransacao tipoTransacao = tipoTransacaoRepository.findByNome(transacao.getTipoTransacao().getNome());
		
		if (Objects.nonNull(categoria)) {
			transacaoModel.setCategoria(categoria);
		} else {
			throw new Exception("Categoria inválidia!");
		}
		
		if (Objects.nonNull(tipoTransacao)) {
			transacaoModel.setTipoTransacao(tipoTransacao);
		} else {
			throw new Exception("Tipo transação inválidia!");
		}
		
		try {			
			repository.save(transacaoModel);
			retorno.setMensagem("Transação cadastrada com sucesso.");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Erro ao cadastrar transação");
		}
		
		return retorno;
	}

	@Override
	public List<TransacaoDTO> listarTransacoesPorFiltro(FiltroDTO filtro) {
		if (filtro.getTipoTransacao().getNome().equals("Saida")) {
			filtro.getTipoTransacao().setNome("Saída");
		};
		if (filtro.getDescricao().equals("")) {
			filtro.setDescricao(null);
		}
		List<Transacao> transacoes = repository.listarTransacoesPorFiltro(
				filtro.getCategoria().getNome().equals("") || Objects.isNull(filtro.getCategoria()) ? null : filtro.getCategoria().getNome(),
                filtro.getDescricao(),
                filtro.getValor(),
                filtro.getTipoTransacao().getNome(),
                filtro.getDataInicial(),
                filtro.getDataFinal());
		return transacoes.stream().map(transacao -> {return utils.convertTransacaoToDTO(transacao);}).collect(Collectors.toList());
	}

	public List<TransacaoDTO> listarTransacoes() {
		return repository
				.findAll()
				.stream()
				.map(transacao -> {return utils.convertTransacaoToDTO(transacao);})
				.collect(Collectors.toList());
	}
	
	private Transacao findByIdentificador(Long identificador) {
		return repository.findById(identificador).get();
	}
	
	public RetornoEnvioDTO excluirTransacao(Long identificador) {
		RetornoEnvioDTO retorno = new RetornoEnvioDTO();
		
		Transacao transacao = this.findByIdentificador(identificador);
		if (Objects.isNull(transacao)) {
			retorno.setMensagem("Transação não encontrada");
		}
		
		try {
			repository.delete(transacao);
		} catch (Exception e) {
			retorno.setMensagem("Erro ao excluir transação.");
		}
		
		retorno.setMensagem("Transação excluída com sucesso!");
		
		return retorno;
	}

	public RetornoEnvioDTO editarTransacao(Long identificador, TransacaoDTO transacao) {
		RetornoEnvioDTO retorno = new RetornoEnvioDTO();
		
		Transacao transacaoModel = this.findByIdentificador(identificador);
		if (Objects.isNull(transacaoModel)) {
			retorno.setMensagem("Transação não encontrada");
		}
		
		Categoria categoria = categoriaRepository.findByNome(transacao.getCategoria().getNome());
		TipoTransacao tipoTransacao = tipoTransacaoRepository.findByNome(transacao.getTipoTransacao().getNome());
		
		transacaoModel.setCategoria(categoria);
		transacaoModel.setData(transacao.getData());
		transacaoModel.setDescricao(transacao.getDescricao());
		transacaoModel.setTipoTransacao(tipoTransacao);
		transacaoModel.setValor(transacao.getValor());
		
		try {
			repository.save(transacaoModel);
			retorno.setMensagem("Transação editada com sucesso.");
		} catch (Exception e){
			retorno.setMensagem("Erro ao editar transação." + e.getMessage());
		}
		
		
		return retorno;
	}

}
