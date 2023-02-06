package com.chat.gui;

import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;

import javafx.scene.layout.FlowPane;

public class PanelesScroll {
	
	private ScrollPane panelIzq;
	private ScrollPane panelDer;
	
	public PanelesScroll() {
		panelDer = new ScrollPane();
		panelIzq = new ScrollPane();
	}

	public ScrollPane getPanelIzq() {
		return panelIzq;
	}

	public ScrollPane getPanelDer() {
		return panelDer;
	}
	
	public ScrollPane panelDerecho(Node contenidoDer) {
		
		panelDer.setContent(contenidoDer);
		panelDer.setFitToWidth(true);
		panelDer.setHbarPolicy(ScrollBarPolicy.NEVER);
		panelDer.setPrefWidth(690);
		panelDer.setStyle("-fx-background: rgb(19,28,70)");
		panelDer.setPannable(true);
		return panelDer;
		
	}
	
	public ScrollPane panelIzq(Node layout) {
        panelIzq.setContent(layout);
        panelIzq.setStyle("-fx-background-color: transparent");
        panelIzq.setFitToWidth(true);
        panelIzq.setHbarPolicy(ScrollBarPolicy.NEVER);
        panelIzq.setPrefWidth(345);
        panelIzq.setPannable(true);

        return panelIzq;
}
	
	public void ajusteDesplDer(FlowPane contenidoDer) {
		panelDer.vvalueProperty().bind(new ObservableValue<Number>() {

			@Override
			public void addListener(InvalidationListener event) {
				panelDer.vvalueProperty().bind(contenidoDer.heightProperty());
				
			}

			@Override
			public void removeListener(InvalidationListener arg0) {
				
			}

			@Override
			public void addListener(ChangeListener<? super Number> arg0) {
				
			}

			@Override
			public Number getValue() {
				return 2;
			}

			@Override
			public void removeListener(ChangeListener<? super Number> arg0) {
				
			}
		});
	}
	

}