package com.controleDeGastos.models;

import java.util.Date;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
@Table(name = "Transacoes")
public class Transacao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long identificador;
	
	@ManyToOne
	@Nonnull
	@JoinColumn(name = "identificadorTAB_Categoria")
	private Categoria categoria;
	
	@Column
	private String descricao;
	
	@Column
	@Nonnull
	private Float valor;
	
	@ManyToOne
	@Nonnull
	@JoinColumn(name = "identificadorTAB_TipoTransacao")
	private TipoTransacao tipoTransacao;
	
	@Column(name = "data")
	@Nonnull
	private Date data;
	
}
