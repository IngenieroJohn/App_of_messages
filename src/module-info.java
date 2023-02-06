module prueba {
	requires javafx.controls;
	requires java.desktop;
	requires org.eclipse.paho.client.mqttv3;
	requires com.google.gson;
	requires javafx.graphics;
	requires java.sql;
	
	opens application to javafx.graphics, javafx.fxml;
}
