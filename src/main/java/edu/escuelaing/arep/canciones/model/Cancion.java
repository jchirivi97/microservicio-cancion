package edu.escuelaing.arep.canciones.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
@Table(name ="cancion")
public class Cancion {
	
	
	@Id
	@Column(name="id")
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="contenido")
	@Size(min=1, max=100)
	private String contenido;
	
	@Column(name="nombre")
	@Size(min=1, max=100)
	private String nombre;
	
	
	public Cancion () {
		
	}
	
	public Cancion (int id,String contenido,String nombre) {
		this.id = id;
		this.contenido = contenido;
		this.nombre = nombre;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getContenido() {
		return contenido;
	}


	public void setContenido(String contenido) {
		this.contenido = contenido;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
