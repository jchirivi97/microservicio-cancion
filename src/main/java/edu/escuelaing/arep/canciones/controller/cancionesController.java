package edu.escuelaing.arep.canciones.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.escuelaing.arep.canciones.model.Cancion;
import edu.escuelaing.arep.canciones.services.cancionesServices;

@RestController
@RequestMapping(value="/canciones")
public class cancionesController {
	
	@Autowired
	cancionesServices cancionServ;
	
	@RequestMapping(method = RequestMethod.GET, path="/{id}")
	public ResponseEntity<Cancion> getcancion(@PathVariable("id") int id){
		Cancion canc = cancionServ.getCancion(id);
		return ResponseEntity.ok(canc);
	}

	@RequestMapping(method = RequestMethod.POST)
	public void SaveCancion(Cancion cancion) {
		cancionServ.saveCancion(cancion);
	};
}
