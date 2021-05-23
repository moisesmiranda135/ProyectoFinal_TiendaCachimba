package com.salesianostriana.dam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.salesianostriana.dam.modal.Cachimba;
import com.salesianostriana.dam.modal.Marca;
import com.salesianostriana.dam.servicios.CachimbaServicio;
import com.salesianostriana.dam.servicios.MarcaServicio;

@Controller
/**
 * En esta case controller tenemos los métodos para agregar,editar y borrar una marca
 * @author Moi
 *
 */
public class MarcaController {
	
	
	@Autowired
	private CachimbaServicio cachimbaservicio;
	
	@Autowired
	private MarcaServicio marcaservicio;
	

	
	@GetMapping("/nuevaMarca")
	/**
	 * Este es el método get para imprimir el formulario de la marca en blanco y así escribir los datos 
	 * para agregar una nueva marca
	 */
	public String nuevaMarcaAgregada(Model model) {
		model.addAttribute("marca", new Marca());
		return "agregar-marca";
	}
	
	
	@PostMapping("/nueva/marca/submit")
	/**
	 * Este es el método post que recogen los datos de los campos del formulario y procesa esa información
	 */
	public String submitNuevaMarca(@ModelAttribute("marca") Marca marca, Model model) {
		
		marcaservicio.save(marca);
		
		return "redirect:/";
	}
	
	
	@GetMapping("/editar/marca/{id}")
	/**
	 * Método que atiende a la petición de editar una marca, en esta caso, cuando el usuario pulse
	 * el botón de editar al pinchar en el botón de editar una marca, dentro del método,
	 * buscamos esa marca por su id y, si es
	 * distinta de null añadimos la marca al modelo y en el return llevamos a mostrar 
	 * el formulario de la marca pero aparecerá ahora ya con datos en los campos.
	 * Si la marca buscada es null llamamos en el return a través del redirect,
	 * al método controller que pinta la lista
	 * de las marcas de nuevo.
	 */
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
	/**
	 * Para el borrado de marcas, el uso del id funciona de la misma manera que en el editar
	 * Buscamos la marca y, si la encontramos, comprobamos que no tenga cachimbas, si tiene
	 * cachimbas devolveremos una página error
	 * y si no tiene cachimbas asociadas, se borra la marca con el método borrarMarca.
	 */
	public String borrarMarca(@PathVariable("id") Long id, Model model) {

		Marca marca = marcaservicio.findById(id);

		if (marca != null) {
			marcaservicio.delete(marca);
		}

		return "redirect:/";

	}
}
