package edu.escuelaing.arep.canciones.services.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.escuelaing.arep.canciones.model.Cancion;
import edu.escuelaing.arep.canciones.model.ListaReproduccion;
import edu.escuelaing.arep.canciones.repository.cancionRepository;
import edu.escuelaing.arep.canciones.repository.listaReproduccionRepository;
import edu.escuelaing.arep.canciones.services.listaReproduccionServices;

@Service
public class listaReproduccionServicesImpl implements listaReproduccionServices {
	
	@Autowired
	cancionRepository cancionRepo;
	
	@Autowired
	listaReproduccionRepository listReproduccionRepo;

	@Override
	public void saveListaCancion(ListaReproduccion listareproduccion) {
		listReproduccionRepo.save(listareproduccion);
		
	}

	@Override
	public ListaReproduccion getListaReproduccion(int id) {
		return listReproduccionRepo.findById(id).get();
	}

	@Override
	public List<ListaReproduccion> getListasReproduccionesUser(String usuario) {
		return listReproduccionRepo.getListaReproduccionesUser(usuario);
	}

	@Override
	public List<ListaReproduccion> getListaCanciones(String usuario,String nombre) {
		return listReproduccionRepo.getListaCanciones(usuario,nombre);
	}

	
	
}
