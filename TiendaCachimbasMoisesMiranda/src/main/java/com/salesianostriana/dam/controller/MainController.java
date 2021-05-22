package com.salesianostriana.dam.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.salesianostriana.dam.modal.Cachimba;
import com.salesianostriana.dam.servicios.CachimbaServicio;
import com.salesianostriana.dam.servicios.MarcaServicio;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MainController {

	private final CachimbaServicio caServicio;
	private final MarcaServicio marcaServicio;
	
	
	@GetMapping("/")
	public String todasLasCachimbas(@RequestParam(name="idMarca", required=false) Long idMarca, Model model) {		
		
	
		model.addAttribute("marcas", marcaServicio.findAll());
		
		List<Cachimba> cachimbas;
	
		
		
		if (idMarca == null) {
			cachimbas = caServicio.findAll();
		} else {			
			cachimbas= caServicio.findByMarcaId(idMarca);
		}
		
		model.addAttribute("cachimbas", cachimbas);
		
		return "index";
	}
	
	//Método para mostrar detalles
	@GetMapping("/cachimba/{id}")
	public String MostrarDetalles(@PathVariable("id") Long id, Model model) {
		
		
		Cachimba c = caServicio.findById(id);
		
		if (c != null) {
			model.addAttribute("cachimba", c);
			return "descripcion";
		}
		
		return "redirect:/";
		
	}
}
