package com.controleDeGastos.models;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "tab_tipotransacao32")
public class TipoTransacao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long identificador;
	
	@Column
	@Nonnull
	private String nome;
}
