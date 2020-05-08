package edu.escuelaing.arep.canciones.model;


public class usuario {


	private String nickname;
	
	
	private String nombre;
	
	
	public usuario() {
		
	}
	
	public usuario(String nickname,String nombre) {
		this.nickname = nickname;
		this.nombre = nombre;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
