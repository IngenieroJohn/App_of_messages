package com.chat.gui;



import java.sql.Statement;

import com.chat.repositorio.UserRepository;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

public class Images {
	private Image images;
    private Circle dise�oImg;
    UserRepository imgUser = new UserRepository();


    public Images() {
        dise�oImg = new Circle();
        dise�oImg.setStroke(Color.TRANSPARENT);
        dise�oImg.setSmooth(true);
    }

    public Images(String images, int ratio) {
        this.images = new Image(images);
        dise�oImg = new Circle();
        dise�oImg.setRadius(ratio);
        dise�oImg.setFill(new ImagePattern(this.images));
        dise�oImg.setStroke(Color.TRANSPARENT);
        dise�oImg.setSmooth(true);
    }

    public Image getImages() {
        return images;
    }

    public Circle getDise�oImg() {
        return dise�oImg;
    }

    public Circle imgUsuarios(int radio, int user) {
        images = new Image(imgUser.Getuserlocal(user).getImage());
        dise�oImg.setRadius(radio);
        dise�oImg.setFill(new ImagePattern(images));     
        return dise�oImg;
        
    }

}
