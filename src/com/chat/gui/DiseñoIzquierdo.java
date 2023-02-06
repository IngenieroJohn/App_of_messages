package com.chat.gui;

import java.time.LocalDateTime;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class DiseñoIzquierdo {
	Images userImages = new Images();
	private VBox diseño1;
	private VBox diseño2;
	private HBox contenido;
	private Label ultimoMsj;
	private Label contacto;
	private Label hours;
	
	public DiseñoIzquierdo() {
		 diseño1 = new VBox(10);
		 diseño2 = new VBox(-20);
		 diseño2.setAlignment(Pos.TOP_RIGHT);
		 diseño2.setMinWidth(240);
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

	public VBox getDiseño1() {
		return diseño1;
	}

	public void setDiseño1(VBox diseño1) {
		this.diseño1 = diseño1;
	}

	public VBox getDiseño2() {
		return diseño2;
	}

	public void setDiseño2(VBox diseño2) {
		this.diseño2 = diseño2;
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
		diseño1.getChildren().addAll(contacto, ultimoMsj);
		diseño2.getChildren().addAll(hours, diseño1);
		contenido.getChildren().addAll(userImages.getDiseñoImg(), diseño2);	
	}

}
