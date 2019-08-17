package com.lm.clube.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lm.clube.models.Categoria;
import com.lm.clube.repositories.Categorias;


@RestController
@RequestMapping("/api/categorias")
public class CategoriasControllerAPI {

	@Autowired
	private Categorias categorias;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public Collection<Categoria> listaConvidados() {
		return categorias.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Optional<Categoria> getConvidado(@PathVariable("id") Long id) {
		return this.categorias.findById(id);
	}
	

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> removeConvidado(@PathVariable("id") Long id) {
		Optional<Categoria> c = categorias.findById(id);
		if (c == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		categorias.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public  ResponseEntity<?> saveConvidado(@RequestBody Categoria categoria) {
		System.out.println(categoria.getId()+"  "+categoria.getNome()+" "+categoria.getDescricao());
		if (categoria.getId() != null) {
			//return new ResponseEntity<>(HttpStatus.OK);
			return new ResponseEntity<Categoria> (categorias.save(categoria), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
}

