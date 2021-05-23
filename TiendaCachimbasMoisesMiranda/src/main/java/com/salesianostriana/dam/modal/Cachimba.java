package com.salesianostriana.dam.modal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Entity
/**
 * Esta es la clase pojo cachimba donde guardamos los atributos de dicha clase.
 * @author Moi
 *
 */
public class Cachimba {
	
	@Id @GeneratedValue
	private long id;
	
	private String nombre;
	private String color;
	private String materialFabricacion;
	@Lob
	private String descripcion;
	
	
	private double precio;
	
	private int altura;  //La alura se expresará en centímetros/cm
	private int numConexManguera;
	
	private String imagen;
	
	
	@ManyToOne
	private Marca marca;
	
	
	
	//Constructores
	public Cachimba( String nombre, String color, String materialFabricacion, String descripcion, double precio,
			int altura, int numConexManguera, String imagen) {
		super();
		this.nombre = nombre;
		this.color = color;
		this.materialFabricacion = materialFabricacion;
		this.descripcion = descripcion;
		this.precio = precio;
		this.altura = altura;
		this.numConexManguera = numConexManguera;
		this.imagen = imagen;
	}



	public Cachimba(String nombre, String color, String materialFabricacion, String descripcion, double precio,
			int altura, int numConexManguera, String imagen, Marca marca) {
		super();
		this.nombre = nombre;
		this.color = color;
		this.materialFabricacion = materialFabricacion;
		this.descripcion = descripcion;
		this.precio = precio;
		this.altura = altura;
		this.numConexManguera = numConexManguera;
		this.imagen = imagen;
		this.marca = marca;
	}
	
	
	
}
