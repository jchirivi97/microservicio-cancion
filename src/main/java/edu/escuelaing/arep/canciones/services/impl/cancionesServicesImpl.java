package edu.escuelaing.arep.canciones.services.impl;

import org.springframework.stereotype.Service;

import edu.escuelaing.arep.canciones.model.Cancion;
import edu.escuelaing.arep.canciones.repository.cancionRepository;
import edu.escuelaing.arep.canciones.services.cancionesServices;

@Service
public class cancionesServicesImpl implements cancionesServices {
	
	cancionRepository cancionRepo;
	
	private void ConectBd() {
		cancionRepo = new cancionRepository();
	}
	
	
	@Override
	public Cancion getCancion(int id) {
		ConectBd();
		return cancionRepo.getCancion(id); 
	}

	@Override
	public void saveCancion(Cancion cancion) {
		cancionRepo.saveCancion(cancion.getId(), cancion.getNombre(),cancion.getContenido());
	}

}
