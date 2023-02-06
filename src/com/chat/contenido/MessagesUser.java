package com.chat.contenido;

import java.util.ArrayList;
import java.util.List;

public class MessagesUser {
	
	String userActivo, contacto, contenido, hora;
	
	public MessagesUser(String user, String contacto, String contenido) {
		this.userActivo = user;
		this.contacto = contacto;
		this.contenido = contenido;
	}
	
	public MessagesUser(String contacto, String contenido) {
		this.contacto = contacto;
		this.contenido = contenido;
	}

	public String getUser() {
		return userActivo;
	}

	public void setUser(String user) {
		this.userActivo = user;
	}
	
	public String getContacto() {
		return contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public String getHora() {
		return hora;
	}
	
	public List<String> getDeHoras(){
		List<String> resultado = new ArrayList<>();
		resultado.add("08:30 a.m.");
		resultado.add("07:45 p.m.");
		resultado.add("10:21 a.m.");
		resultado.add("09:35 a.m.");
		resultado.add("11:00 a.m.");
		resultado.add("02:33 p.m.");
		resultado.add("04:40 p.m.");
		resultado.add("05:20 p.m.");
		resultado.add("12:00 p.m.");
		resultado.add("08:05 a.m");
		resultado.add("08:50 p.m.");
		resultado.add("10:10 p.m");
		
		return resultado;
	}


}