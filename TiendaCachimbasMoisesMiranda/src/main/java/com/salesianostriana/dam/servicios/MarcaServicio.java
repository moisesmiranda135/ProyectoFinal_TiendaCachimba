package com.salesianostriana.dam.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.base.BaseService;
import com.salesianostriana.dam.modal.Cachimba;
import com.salesianostriana.dam.modal.Marca;
import com.salesianostriana.dam.repos.MarcaRepository;


@Service
public class MarcaServicio extends BaseService<Marca, Long, MarcaRepository> {

	public MarcaServicio(MarcaRepository repo) {
		super(repo);
	}

	@Override
	public List<Cachimba> findByMarcaId(Long marcaId) {
		// TODO Auto-generated method stub
		return null;
	}

}
