package edu.escuelaing.arep.canciones.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.escuelaing.arep.canciones.model.Cancion;
import edu.escuelaing.arep.canciones.model.ListaReproduccion;

public interface listaReproduccionRepository extends JpaRepository<ListaReproduccion,Integer> {
	
	
	@Query(value="select l.id as id, l.idcancion as idcancion, l.nombre as nombre, l.usuario as usuario from lista_reproduccion l where l.usuario= :usuario and l.nombre= :nombre",nativeQuery = true)
	List<ListaReproduccion> getListaCanciones(String usuario,String nombre);

	@Query(value="select  l.id as id, l.idcancion as idcancion, l.nombre as nombre, l.usuario as usuario from lista_reproduccion l where l.usuario= :usuario",nativeQuery = true)
	List<ListaReproduccion> getListaReproduccionesUser(String usuario);
}
