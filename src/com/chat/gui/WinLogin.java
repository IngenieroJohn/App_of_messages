package com.chat.gui;


import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class WinLogin {
	
	private TextField user;
	private PasswordField clave;
	private Button login;
	private Label titulo;
	
	public WinLogin() {
		
	}
	
	public TextField getUser() {
		return user;
	}

	public PasswordField getClave() {
		return clave;
	}

	public Button getLogin() {
		return login;
	}

	public Label getTitulo() {
		return titulo;
	}
	
	
	
	

	public void userText() {
		user = new TextField();
		user.setFont(Font.font("Tiny", FontWeight.NORMAL, 14));
		user.setPromptText("User");
		user.setFocusTraversable(false);
		user.setMaxWidth(200);
	}
	
	public void clavePass() {
		clave = new PasswordField();
		clave.setFont(Font.font("Tiny", FontWeight.NORMAL, 14));
		clave.setPromptText("Password");
		clave.setFocusTraversable(false);
		clave.setMaxWidth(200);
	}
	
	public void loginButton() {
		login = new Button("Iniciar sesión");
		login.setFont(Font.font("Tiny", FontWeight.NORMAL, 14));
		
		login.setMinHeight(30);
	}
	
	public void tituloLabel() {
		titulo = new Label("Discord Penguin");
		titulo.setFont(Font.font("Tiny", FontWeight.EXTRA_BOLD, 40));
		titulo.setStyle("-fx-text-fill: white");
	}

}