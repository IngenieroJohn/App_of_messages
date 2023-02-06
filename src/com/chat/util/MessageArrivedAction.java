package com.chat.util;

import com.chat.domain.Message;

public interface MessageArrivedAction {
	
	public void messageArrived(String topic, Message message);

}
