package edu.escuelaing.arep.canciones.services;


import java.util.List;

import edu.escuelaing.arep.canciones.model.Cancion;
import edu.escuelaing.arep.canciones.model.ListaReproduccion;

public interface listaReproduccionServices {

	
	void saveListaCancion(ListaReproduccion listareproduccion);
	
	
	ListaReproduccion getListaReproduccion(int id); 	
	
	List<ListaReproduccion> getListasReproduccionesUser(String usuario);
	
	List<ListaReproduccion> getListaCanciones(String usuario,String nombre);
}
