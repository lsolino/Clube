package com.lm.clube.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lm.clube.models.Partida;
import com.lm.clube.repositories.Categorias;
import com.lm.clube.repositories.Partidas;

@Controller
@RequestMapping("/partidas")
public class PartidasController {
	
	@Autowired
	Partidas partidas;
	
	@Autowired
	Categorias categorias;
	
	@RequestMapping("")
	public ModelAndView inicio() {
		ModelAndView mv = new ModelAndView("PaginaPartida.html");
		mv.addObject(new Partida());
		mv.addObject("categorias", categorias.findAll());
		mv.addObject("partidas", partidas.findAll());
		return mv;	
	}
	
	@RequestMapping(value="",method=RequestMethod.POST)
	public String salvar(Partida partida) {
		partidas.save(partida);
		return "redirect:/partidas";
	}
	
	@RequestMapping(value="alterar/{id}")
	public ModelAndView alterar(@PathVariable Long id) {
		ModelAndView mv = new ModelAndView("PaginaPartida.html");
		Partida partida = partidas.getOne(id);
		mv.addObject(partida);
		mv.addObject("categorias", categorias.findAll());
		mv.addObject("partidas",partidas.findAll());
		return mv;
	}
	
	//Excluir
	@RequestMapping(value="/excluir/{id}")
	public String excluir(@PathVariable Long id) {
		partidas.deleteById(id);
		//attributes.addFlashAttribute("mensagem", "Proprietario excluído com sucesso!");
		return "redirect:/partidas";
	}

}
