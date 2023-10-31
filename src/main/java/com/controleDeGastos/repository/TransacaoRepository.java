package com.controleDeGastos.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.controleDeGastos.models.Transacao;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
	
	@Query("SELECT t FROM Transacao t "
	        + "JOIN t.categoria c "
	        + "JOIN t.tipoTransacao tp "
	        + "WHERE (:categoria IS NULL OR c.nome = :categoria) "
	        + "AND (:descricao IS NULL OR t.descricao LIKE CONCAT('%', :descricao, '%')) "
	        + "AND (:valor IS NULL OR t.valor >= :valor) "
	        + "AND (:tipoTransacao IS NULL OR tp.nome = :tipoTransacao) "
	        + "AND (:dataInicial IS NULL OR :dataFinal IS NULL OR t.data BETWEEN :dataInicial AND :dataFinal)")
	List<Transacao> listarTransacoesPorFiltro(@Param("categoria") String categoria, 
	                                          @Param("descricao") String descricao, 
	                                          @Param("valor") Float valor, 
	                                          @Param("tipoTransacao") String tipoTransacao, 
	                                          @Param("dataInicial") Date dataInicial, 
	                                          @Param("dataFinal") Date dataFinal);

}
