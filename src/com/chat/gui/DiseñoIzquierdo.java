package com.chat.gui;

import java.time.LocalDateTime;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Dise�oIzquierdo {
	Images userImages = new Images();
	private VBox dise�o1;
	private VBox dise�o2;
	private HBox contenido;
	private Label ultimoMsj;
	private Label contacto;
	private Label hours;
	
	public Dise�oIzquierdo() {
		 dise�o1 = new VBox(10);
		 dise�o2 = new VBox(-20);
		 dise�o2.setAlignment(Pos.TOP_RIGHT);
		 dise�o2.setMinWidth(240);
		 contenido = new HBox(10);
		 contenido.setStyle("-fx-border-color: white");
		 contenido.setPadding(new Insets(10, 5, 10, 10));
		 ultimoMsj = new Label();
		 ultimoMsj.setFont(Font.font("Comic Sans Ms", FontWeight.NORMAL, 12));	
		 ultimoMsj.setMaxWidth(230);
		 contacto = new Label();
		 contacto.setFont(Font.font("Comic Sans Ms", FontWeight.BOLD, 14));
		 hours = new Label();
		 hours.setFont(Font.font("Comic Sans Ms", FontWeight.NORMAL, 12));
	}

	public VBox getDise�o1() {
		return dise�o1;
	}

	public void setDise�o1(VBox dise�o1) {
		this.dise�o1 = dise�o1;
	}

	public VBox getDise�o2() {
		return dise�o2;
	}

	public void setDise�o2(VBox dise�o2) {
		this.dise�o2 = dise�o2;
	}

	public HBox getContenido() {
		return contenido;
	}

	public void setContenido(HBox contenido) {
		this.contenido = contenido;
	}

	public Label getUltimoMsj() {
		return ultimoMsj;
	}

	public void setUltimoMsj(Label ultimoMsj) {
		this.ultimoMsj = ultimoMsj;
	}

	public Label getContacto() {
		return contacto;
	}

	public void setContacto(Label contacto) {
		this.contacto = contacto;
	}

	public Label getHours() {
		return hours;
	}

	public void setHours(Label hours) {
		this.hours = hours;
	}
	
	public void contenidoMsj(String mensaje, String contact, LocalDateTime hora, int user, int radio) {
		String hora2= hora.getHour()+":"+hora.getMinute(); 
		userImages.imgUsuarios(radio, user);
		ultimoMsj.setText(mensaje);
		contacto.setText(contact);
		hours.setText(hora2);
		dise�o1.getChildren().addAll(contacto, ultimoMsj);
		dise�o2.getChildren().addAll(hours, dise�o1);
		contenido.getChildren().addAll(userImages.getDise�oImg(), dise�o2);	
	}

}
