package com.salesianostriana.dam.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianostriana.dam.modal.Cachimba;

public interface CachimbaRepository extends JpaRepository<Cachimba,Long> {

	@Query("select c from Cachimba c where c.marca.id = ?1")
	public List<Cachimba> findByMarcaId(Long marcaId);

}

