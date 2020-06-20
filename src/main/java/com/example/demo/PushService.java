package com.example.demo;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.linecorp.bot.client.LineMessagingClient;
import com.linecorp.bot.model.PushMessage;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.model.response.BotApiResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PushService {

	@Autowired
	LineMessagingClient lineMessagingClient;

	public void pushMessage(String message) {

		try {

	    	TextMessage textMessage = new TextMessage(message);
	    	PushMessage pushMessage = new PushMessage("U3ffa70b26534f3f36f59c17b82e7295d", textMessage);

	    	BotApiResponse response = lineMessagingClient.pushMessage(pushMessage).get();

	      System.out.println(response);

	    } catch (InterruptedException | ExecutionException e) {
	      throw new RuntimeException(e);
	    }

	}

}
