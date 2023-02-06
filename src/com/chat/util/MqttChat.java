package com.chat.util;

import java.time.LocalDateTime;


import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import com.chat.domain.Message;
import com.chat.domain.UsersLocal;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class MqttChat {

	
	
	String broker = "tcp://localhost:1883";
    
    MqttClient client;
    
    public MqttChat() {
    	
    }
    
    public void connect(UsersLocal user) throws MqttException {
    	MemoryPersistence persistence = new MemoryPersistence();
    	client = new MqttClient(broker, user.getUsername(), persistence);
		MqttConnectOptions connOpts = new MqttConnectOptions();
		client.connect(connOpts);
//		System.out.println("Connect OK");
    }
    
    public void subscribe(String topic) throws MqttException{
		client.subscribe(topic);
//		System.out.println("Subscribe OK: " + topic);
    }
    
    public void unsubscribe(String topic) throws MqttException {
		client.unsubscribe(topic);
		System.out.println("Unsubscribe OK");
    }
    
    public void sendMessage(String topic, Message message) throws MqttPersistenceException, MqttException {
//    	System.out.print(message);
    	MqttMessage mqttMessage = new MqttMessage(message.toString().getBytes());
    	client.publish(topic, mqttMessage);
    	System.out.println(topic);
    }
    
    @SuppressWarnings("deprecation")
    public void messageArrived(MessageArrivedAction action) {
    	
    	client.setCallback(new MqttCallback() {
			
			@Override
			public void messageArrived(String topic, MqttMessage message) throws Exception {
				System.out.println("messageArrived: " + topic);
				String text = new String(message.getPayload());
				
				JsonParser parser = new JsonParser();
				JsonObject jsonObjectMsg = parser.parse(text.toString()).getAsJsonObject();
				
				int idMsg = jsonObjectMsg.get("id").getAsInt();
				String content = jsonObjectMsg.get("content").getAsString();
//				String date = jsonObjectMsg.get("date").getAsString();
				
				JsonObject jsonFrom = jsonObjectMsg.get("from").getAsJsonObject();
				int fromId = jsonFrom.get("id").getAsInt();
				String fromUserName = jsonFrom.get("userName").getAsString();
				
				JsonObject jsonTo = jsonObjectMsg.get("to").getAsJsonObject();
				int toId = jsonTo.get("id").getAsInt();
				String toUserName = jsonTo.get("userName").getAsString();
				
				UsersLocal from = new UsersLocal(fromId, fromUserName);
                UsersLocal to = new UsersLocal(toId, toUserName);

                Message newMessage = new Message(idMsg, from, to, content, LocalDateTime.now());
				
				action.messageArrived(topic, newMessage);
				
			}
			
			@Override
			public void deliveryComplete(IMqttDeliveryToken arg0) {
			}
			
			@Override
			public void connectionLost(Throwable arg0) {
			}
		});
    	
    }
}

