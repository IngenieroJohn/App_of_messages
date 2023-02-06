package com.chat.gui;



import java.sql.Statement;

import com.chat.repositorio.UserRepository;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

public class Images {
	private Image images;
    private Circle diseñoImg;
    UserRepository imgUser = new UserRepository();


    public Images() {
        diseñoImg = new Circle();
        diseñoImg.setStroke(Color.TRANSPARENT);
        diseñoImg.setSmooth(true);
    }

    public Images(String images, int ratio) {
        this.images = new Image(images);
        diseñoImg = new Circle();
        diseñoImg.setRadius(ratio);
        diseñoImg.setFill(new ImagePattern(this.images));
        diseñoImg.setStroke(Color.TRANSPARENT);
        diseñoImg.setSmooth(true);
    }

    public Image getImages() {
        return images;
    }

    public Circle getDiseñoImg() {
        return diseñoImg;
    }

    public Circle imgUsuarios(int radio, int user) {
        images = new Image(imgUser.Getuserlocal(user).getImage());
        diseñoImg.setRadius(radio);
        diseñoImg.setFill(new ImagePattern(images));     
        return diseñoImg;
        
    }

}
