package com.salesianostriana.dam.modal;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
/**
 * Esta es la clase pojo marca donde guardamos los atributos de dicha clase.
 * @author Moi
 *
 */
public class Marca {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String nombre;
	@Lob
	private String descripcion;
	
	
	public Marca(String nombre, String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy = "marca", fetch = FetchType.EAGER)
	private List<Cachimba> cachimbas = new ArrayList<>();
	
	
	public void addCachimba(Cachimba a) {
		this.cachimbas.add(a);
		a.setMarca(this);
	}

	
	public void removeCachimba(Cachimba a) {
		this.cachimbas.remove(a);
		a.setMarca(null);
	}

}