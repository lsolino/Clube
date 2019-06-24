package com.lm.clube.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lm.clube.models.Categoria;


public interface Categorias extends JpaRepository <Categoria,Long> {

}
