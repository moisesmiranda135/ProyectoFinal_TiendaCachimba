package com.salesianostriana.dam.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.base.BaseService;
import com.salesianostriana.dam.modal.Cachimba;
import com.salesianostriana.dam.repos.CachimbaRepository;

@Service
public class CachimbaServicio extends BaseService<Cachimba, Long, CachimbaRepository>{

	@Autowired
	private CachimbaRepository repositorio;
	
	public CachimbaServicio(CachimbaRepository repo) {
		super(repo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Cachimba> findByMarcaId(Long marcaId) {
		// TODO Auto-generated method stub
		return repositorio.findByMarcaId(marcaId);
	}

	

	
}
