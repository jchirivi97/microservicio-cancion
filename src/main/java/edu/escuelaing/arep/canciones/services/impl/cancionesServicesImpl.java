package edu.escuelaing.arep.canciones.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.escuelaing.arep.canciones.model.Cancion;
import edu.escuelaing.arep.canciones.repository.cancionRepository;
import edu.escuelaing.arep.canciones.services.cancionesServices;

@Service
public class cancionesServicesImpl implements cancionesServices {
	

	@Autowired
	cancionRepository cancionRepo;
	
	@Override
	public Cancion getCancion(int id) {
		Optional<Cancion> canc = cancionRepo.findById(id);
		return canc.get();
	}

	@Override
	public void saveCancion(Cancion cancion) {
		cancionRepo.save(cancion);
	}

}
