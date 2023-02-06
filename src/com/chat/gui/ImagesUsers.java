package com.chat.gui;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

public class ImagesUsers {
	
	private List<Image> imagenes = new ArrayList<>();
	private Circle imgCircle;
	
	public ImagesUsers() {
		
	}

	public Circle getImgCircle() {
		return imgCircle;
	}

	public List<Image> imagenesUser(){
		imagenes.add(new Image("file:C:\\Users\\User\\OneDrive\\Universidad\\CI 2022-2023\\PAG\\Discord\\src\\com\\chat\\image\\ft1.jpg"));
		imagenes.add(new Image("file:C:\\Users\\User\\OneDrive\\Universidad\\CI 2022-2023\\PAG\\Discord\\src\\com\\chat\\image\\ft2.jpg"));
		imagenes.add(new Image("file:C:\\Users\\User\\OneDrive\\Universidad\\CI 2022-2023\\PAG\\Discord\\src\\com\\chat\\image\\ft3.jpg"));
//		imagenes.add(new Image("file:ft4.jpg"));
//		imagenes.add(new Image("file:ft5.jpg"));
//		imagenes.add(new Image("file:ft6.jpg"));
//		imagenes.add(new Image("file:ft7.jpg"));
//		imagenes.add(new Image("file:ft8.jpg"));
//		imagenes.add(new Image("file:ft9.jpg"));
//		imagenes.add(new Image("file:ft10.jpg"));
//		imagenes.add(new Image("file:ft11.jpg"));
//		imagenes.add(new Image("file:ft12.jpg"));
//		imagenes.add(new Image("file:ft13.jpg"));
//		
		
		return imagenes;
	}
	
	public void imgCircular(Image img) {
		imgCircle = new Circle(30);
		imgCircle.setStroke(Color.TRANSPARENT);
		imgCircle.setEffect(new DropShadow(+2d, 0d, +2d, Color.DARKSEAGREEN));
		imgCircle.setFill(new ImagePattern(img));			        
		imgCircle.setSmooth(true);
		
		
	}

}
