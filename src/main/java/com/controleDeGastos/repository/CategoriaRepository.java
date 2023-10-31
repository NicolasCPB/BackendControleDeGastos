package com.controleDeGastos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.controleDeGastos.models.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

	public Categoria findByNome(String nome);
}
