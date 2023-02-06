package com.chat.gui;

import java.time.LocalDateTime;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

public class DiseñoDerecho {
	Images userImages = new Images();
	private GridPane diseño;
	private HBox contenido;
	private Label bubbleChats;
	private Label hours;
	private boolean validar;
	
	public DiseñoDerecho() {
		validar = false;
		contenido = new HBox(10);
		diseño = new GridPane();
		diseño.setPrefWidth(584);
		contenido.setPadding(new Insets(20, 10, 10, 10));
		bubbleChats = new Label();
		bubbleChats.setTextAlignment(TextAlignment.JUSTIFY);
		bubbleChats.setWrapText(true);
		bubbleChats.setMaxWidth(350);
		bubbleChats.setMinWidth(75);
		bubbleChats.setFont(Font.font("Comic Sans Ms", FontWeight.NORMAL, 12));
		bubbleChats.setPadding(new Insets(6));
		hours = new Label();
		hours.setTextAlignment(TextAlignment.RIGHT);
		hours.setStyle("-fx-text-fill: white");
		hours.setWrapText(true);
		hours.setMaxWidth(350);
		hours.setFont(Font.font("Comic Sans Ms", FontWeight.EXTRA_BOLD, 11));
		hours.setPadding(new Insets(6));
	}
	
	public Label getBubbleChats() {
		return bubbleChats;
	}
	
	public Label getHours() {
		return hours;
	}
	
	public GridPane getDiseño() {
		return diseño;
	}
	
	public HBox getContenido() {
		return contenido;
	}
	
	public boolean getValidar() {
		return validar;
	}	

	public void contenidoMsj(String mensaje, LocalDateTime hora, String color, Pos alineacion, int user, int radio, boolean validar) {
		String hora1= hora.getHour()+":"+hora.getMinute();
		userImages.imgUsuarios(radio, user);
		bubbleChats.setText(mensaje+"\n\n");
		hours.setText(hora1);
		bubbleChats.setStyle("-fx-background-color: "+color+"; -fx-background-radius: 8px; -fx-text-fill: white");
		diseño.add(bubbleChats, 0, 0);
		diseño.add(hours, 1, 1);
		diseño.setVgap(-25);
		diseño.setHgap(-60);
		diseño.setAlignment(alineacion);
		if(validar) {
			contenido.getChildren().addAll(userImages.getDiseñoImg(), diseño);
		}
		else {
			contenido.getChildren().addAll(diseño, userImages.getDiseñoImg());
		}
	}

}
