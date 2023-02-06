package com.chat.gui;

//import javax.swing.Icon;
//import javax.swing.ImageIcon;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

public class WinChat {
	
	private TextField chat;
	private Button enviar;
	private Label globoMsj, contactos, mensajeUser, hora, usuarioId;
	
	public WinChat() {
		
	}

	public TextField getChat() {
		return chat;
	}

	public Button getEnviar() {
		return enviar;
	}

	public Label getGloboMsj() {
		return globoMsj;
	}

	public Label getContactos() {
		return contactos;
	}

	public Label getMensajeUser() {
		return mensajeUser;
	}

	public Label getHora() {
		return hora;
	}
	
	public Label getUsuarioId() {
		return usuarioId;
	}

	public void chat() {
		
		chat = new TextField();
		chat.setFont(Font.font("Tiny", FontWeight.NORMAL, 14));
		chat.setMinSize(600, 10);
	}
	
	public void enviar() {
//		Icon icono = new ImageIcon("C:\\Users\\HP\\OneDrive\\Universidad\\CI 2022-2023\\PAG\\Aplicacion_chat\\3d7a444d-fd14-4b20-a550-fdff1b6fcca3.jpg");
		enviar = new Button("send");
		enviar.setFont(Font.font("Tiny", FontWeight.BOLD, 14));
		enviar.setMinSize(20, 10);
	}
	
	// le damos forma de globo y con color le damos color
	public void globoMsjtest(String mensaje, String color) {
		globoMsj = new Label(mensaje);
		globoMsj.setTextAlignment(TextAlignment.JUSTIFY);
		globoMsj.setWrapText(true);
		globoMsj.setMaxWidth(350);
		globoMsj.setFont(Font.font("Tiny", FontWeight.NORMAL, 12));
		globoMsj.setStyle(color+"; -fx-background-radius: 8px;");
		globoMsj.setPadding(new Insets(6));
	}
	
	
// este metodo posiciona el mesaje derecha o izquierda	
public HBox smspos (Circle cir, Label getglobo, Boolean pos) {
	HBox mensajes = new HBox (20);
	mensajes.getChildren().addAll(getglobo, cir);
	mensajes.setPrefWidth(655);
	if (pos == true) 
		mensajes.setAlignment(Pos.TOP_RIGHT);
	
	mensajes.setPrefWidth(655);
	mensajes.setPadding(new Insets(20, 0, 10, 10));
	return mensajes;
}



// se le da formato al contacto
	public void contactos(String contacto) {
		contactos = new Label(contacto);
		contactos.setFont(Font.font("Tiny", FontWeight.BOLD, 14));
		contactos.setStyle("-fx-text-fill: white");
		
	}
	
	
	
	public void mensajeUser(String contenido) {
		mensajeUser = new Label(contenido);
		mensajeUser.setFont(Font.font("Tiny", FontWeight.NORMAL, 12));	
		mensajeUser.setMaxWidth(170);
		mensajeUser.setStyle("-fx-text-fill: white");
	}
	
	public void hora(String fHora) {
		hora = new Label(fHora);
		hora.setFont(Font.font("Tiny", FontWeight.NORMAL, 12));
		hora.setStyle("-fx-text-fill: white");
	}
	
	public void usuarioId(String id) {
		usuarioId = new Label(id);
		usuarioId.setFont(Font.font("Tiny", FontWeight.BOLD, 16));	
		usuarioId.setStyle("-fx-text-fill: white");
	}	

}