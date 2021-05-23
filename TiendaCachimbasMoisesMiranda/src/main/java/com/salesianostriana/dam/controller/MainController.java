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
	/**
	 * Este método sirve para  poder mostrar las cachimbas y el listado de marcas de forma dinámica en
	 * nuestro index.html
	 *
	 */
	public String todasLasCachimbas(@RequestParam(name="idMarca", required=false) Long idMarca, Model model) {		
		
	
		model.addAttribute("marcas", marcaServicio.findAll());
		
		List<Cachimba> cachimbas;
	
		
		/*Si la marca no es nula, obtenemos todas las cachimbas, si es nula obtenemos todos los de 
		 * la marca con ese id, el llamado idmarca. 
		 */
		if (idMarca == null) {
			cachimbas = caServicio.findAll();
		} else {			
			cachimbas= caServicio.findByMarcaId(idMarca);
		}
		
		model.addAttribute("cachimbas", cachimbas);
		
		return "index";
	}
	
	/**
	 * Este método sirve para mostrar los detalles de una cachimba.
	 *Al hacer click sobre el cachimba, se recoge el id y es el que tenemos en la ruta de getMapping
	 * se pasa el método mediante @PathVariable ("id") Long id
	 */
	@GetMapping("/cachimba/{id}")
	public String MostrarDetalles(@PathVariable("id") Long id, Model model) {
		
		
		Cachimba c = caServicio.findById(id);
		
		/*Si la cachimba no es null se añade al modelo y mostramos la página de la descripción descripcion.html
		*Si no existe, volvemos al index con redirect:/ que es el controlador que hemos nombrado anteriormente
		*/
		if (c != null) {
			model.addAttribute("cachimba", c);
			return "descripcion";
		}
		
		return "redirect:/";
		
	}
}
