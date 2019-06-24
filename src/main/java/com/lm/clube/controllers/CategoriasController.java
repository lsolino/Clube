package com.lm.clube.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lm.clube.models.Categoria;
import com.lm.clube.repositories.Categorias;

@Controller
@RequestMapping("/categorias")
public class CategoriasController {
	
	@Autowired
	Categorias categorias;
	
	@RequestMapping("")
	public ModelAndView inicio() {
		ModelAndView mv = new ModelAndView("PaginaCategoria.html");
		mv.addObject(new Categoria());
		mv.addObject("categorias",categorias.findAll());
		return mv;
	}
	
	@RequestMapping(value="",method=RequestMethod.POST)
	public String salvar(Categoria categoria) {
		categorias.save(categoria);
		return "redirect:/categorias";
	}
	
	@RequestMapping(value="alterar/{id}")
	public ModelAndView alterar(@PathVariable Long id) {
		ModelAndView mv = new ModelAndView("PaginaCategoria.html");
		Categoria categoria = categorias.getOne(id);
		mv.addObject(categoria);
		mv.addObject("categorias",categorias.findAll());
		return mv;
	}
	
	//Excluir
	@RequestMapping(value="/excluir/{id}")
	public String excluir(@PathVariable Long id) {
		categorias.deleteById(id);
		//attributes.addFlashAttribute("mensagem", "Proprietario excluído com sucesso!");
		return "redirect:/categorias";
	}

}
