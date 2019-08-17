package com.lm.clube.models;

import java.util.Calendar;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Partida {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String campeonato;
	private String dataJogo;
	private String local;
	private String adversario;
	private int golsFeitos;
	private int golsSofridos;
	
        @JsonBackReference
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	@NotNull(message = "Categoria Obrigatória")
	private Categoria categoria;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCampeonato() {
		return campeonato;
	}
	public void setCampeonato(String campeonato) {
		this.campeonato = campeonato;
	}
	public String getDataJogo() {
		return dataJogo;
	}
	public void setDataJogo(String dataJogo) {
		this.dataJogo = dataJogo;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getAdversario() {
		return adversario;
	}
	public void setAdversario(String adversario) {
		this.adversario = adversario;
	}
	public int getGolsFeitos() {
		return golsFeitos;
	}
	public void setGolsFeitos(int golsFeitos) {
		this.golsFeitos = golsFeitos;
	}
	public int getGolsSofridos() {
		return golsSofridos;
	}
	public void setGolsSofridos(int golsSofridos) {
		this.golsSofridos = golsSofridos;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}


	

}
