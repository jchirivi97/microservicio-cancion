package edu.escuelaing.arep.canciones.services;

import edu.escuelaing.arep.canciones.model.Cancion;

public interface cancionesServices {
	
	
	Cancion getCancion(int id);
	
	void saveCancion(Cancion cancion);

}
