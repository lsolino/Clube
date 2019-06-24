package com.lm.clube.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lm.clube.models.Jogador;

public interface Jogadores extends JpaRepository<Jogador, Long> {

}
