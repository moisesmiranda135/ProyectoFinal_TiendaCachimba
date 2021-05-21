package com.salesianostriana.dam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.modal.Cachimba;
import com.salesianostriana.dam.modal.Marca;
import com.salesianostriana.dam.servicios.CachimbaServicio;
import com.salesianostriana.dam.servicios.MarcaServicio;

@Controller

public class MarcaController {
	
	
	@Autowired
	private CachimbaServicio cachimbaservicio;
	
	@Autowired
	private MarcaServicio marcaservicio;
	

	
	@GetMapping("/nuevaMarca")
	public String nuevaMarcaAgregada(Model model) {
		model.addAttribute("marca", new Marca());
		return "agregar-marca";
	}
	
	
	@PostMapping("/nueva/marca/submit")
	public String submitNuevaMarca(@ModelAttribute("marca") Marca marca, Model model) {
		
		marcaservicio.save(marca);
		
		return "redirect:/";
	}
	
	
	@GetMapping("/editar/marca/{id}")
	public String editarCategoria(@PathVariable("id") Long id, Model model) {
		
		Marca marca = marcaservicio.findById(id);
		
		
		if (marca != null) {
			model.addAttribute("marca", marca);
			return "agregar-marca";
		} else {
			return "redirect:/";
		}
		
	}
	
	@GetMapping("/borrarMarca/{id}")
	public String borrarMarca(@PathVariable("id") Long id, Model model) {

		Marca marca = marcaservicio.findById(id);

		if (marca != null) {
			marcaservicio.delete(marca);
		}

		return "redirect:/";

	}
}
