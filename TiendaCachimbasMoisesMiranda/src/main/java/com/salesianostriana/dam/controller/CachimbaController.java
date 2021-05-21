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
import com.salesianostriana.dam.servicios.CachimbaServicio;
import com.salesianostriana.dam.servicios.MarcaServicio;

@Controller
public class CachimbaController {
	
	@Autowired
	private CachimbaServicio cachimbaservicio;
	
	@Autowired
	private MarcaServicio marcaservicio;
	
	
	
	@GetMapping("/nueva")
	public String nuevaCachimba(Model model) {
		model.addAttribute("cachimba", new Cachimba());
		
		model.addAttribute("marcas", marcaservicio.findAll());
		return "agregar-cachimba";
	}
	
	
	@PostMapping("/nueva/submit")
	public String submitNuevaCachimba(@ModelAttribute("cachimba") Cachimba cachimba, Model model) {
		
		cachimbaservicio.save(cachimba);
		
		return "redirect:/";
	}
	
	
	@GetMapping("/editarCachimba/{id}")
	public String editarCachimba(@PathVariable("id") Long id, Model model) {
		
		Cachimba cachimba= cachimbaservicio.findById(id);
	
		if (cachimba != null) {
			model.addAttribute("cachimba", cachimba);
			model.addAttribute("marcas", marcaservicio.findAll());
			return "agregar-cachimba";
		} else {
			return "redirect:/";
		}
		
	}
	
	
	@GetMapping("/borrar/{id}")
	public String borrarCachimba(@PathVariable("id") Long id, Model model) {

		Cachimba cachimba = cachimbaservicio.findById(id);

		if (cachimba != null) {
			cachimbaservicio.delete(cachimba);
		}

		return "redirect:/";

	}
}
