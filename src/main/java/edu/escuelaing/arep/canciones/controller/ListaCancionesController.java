package edu.escuelaing.arep.canciones.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.escuelaing.arep.canciones.model.Cancion;
import edu.escuelaing.arep.canciones.model.ListaReproduccion;
import edu.escuelaing.arep.canciones.services.cancionesServices;
import edu.escuelaing.arep.canciones.services.listaReproduccionServices;

@RestController
@RequestMapping(value="/lista")
public class ListaCancionesController {
	
	
	@Autowired
	listaReproduccionServices listServ;
	
	@Autowired
	cancionesServices cancionServ;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<ListaReproduccion> saveLista(ListaReproduccion lista){
		listServ.saveListaCancion(lista);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.GET,path="/{id}")
	public ResponseEntity<ListaReproduccion> getListaReproduccion(@PathVariable("id") int id){
		ListaReproduccion list = listServ.getListaReproduccion(id);
		return ResponseEntity.ok(list);
	} 
	
	@RequestMapping(method = RequestMethod.GET,path="/user/{usuario}")
	public ResponseEntity<List<ListaReproduccion>> getListaUser(@PathVariable("usuario") String usuario){
		List<ListaReproduccion> list = listServ.getListasReproduccionesUser(usuario);
		return ResponseEntity.ok(list);
	}
	
	
	@RequestMapping(method = RequestMethod.GET,path="/canciones/{usuario}/{nombre}")
	public List<Cancion> getListaCanciones(@PathVariable("usuario") String usuario,@PathVariable("nombre") String nombre){
		List<ListaReproduccion> list = listServ.getListaCanciones(usuario,nombre);
		List<Cancion> songs = new ArrayList<Cancion>(); 
		for(int i=0; i < list.size();i++) {
			songs.add(cancionServ.getCancion(list.get(i).getIdcancion()));
		}
		return songs;
	}
	
}
