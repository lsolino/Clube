package com.lm.clube.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lm.clube.models.Jogador;
import com.lm.clube.repositories.Categorias;
import com.lm.clube.repositories.Jogadores;

@Controller
@RequestMapping("/jogadores")
public class JogadoresController {
	
	@Autowired
	Jogadores jogadores;
	
	@Autowired
	Categorias categorias;
	
	@RequestMapping("")
	public ModelAndView inicio() {
		ModelAndView mv = new ModelAndView("PaginaJogador.html");
		mv.addObject(new Jogador());
		mv.addObject("categorias", categorias.findAll());
		mv.addObject("jogadores", jogadores.findAll());
		return mv;
	}
	
	@PostMapping
	public String salvar(Jogador jogador) {
		jogadores.save(jogador);
		return "redirect:/jogadores";
	}
	
	@RequestMapping(value = "/alterar/{id}")
	public ModelAndView alterar(@PathVariable Long id) {
		ModelAndView mv = new ModelAndView("PaginaJogador");
		Jogador jogador = jogadores.getOne(id);
		mv.addObject(jogador);
		mv.addObject("categorias", categorias.findAll());
		mv.addObject("jogadores", jogadores.findAll());
		return mv;
	}
	
	@RequestMapping(value = "/excluir/{id}")
	public String excluir(@PathVariable Long id) {
		jogadores.deleteById(id);
		return "redirect:/jogadores";
	}

}
