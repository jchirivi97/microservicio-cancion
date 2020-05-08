package edu.escuelaing.arep.canciones.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.escuelaing.arep.canciones.model.Cancion;

public interface cancionRepository extends JpaRepository<Cancion,Integer> {
	
}
