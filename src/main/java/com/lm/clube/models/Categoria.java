package com.lm.clube.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private String descricao;
	
	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
	private Set<Jogador> jogadores;
	
	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
	private Set<Partida> partidas;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Set<Jogador> getJogadores() {
		return jogadores;
	}
	public void setJogadores(Set<Jogador> jogadores) {
		this.jogadores = jogadores;
	}
	public Set<Partida> getPartidas() {
		return partidas;
	}
	public void setPartidas(Set<Partida> partidas) {
		this.partidas = partidas;
	}

	

}
