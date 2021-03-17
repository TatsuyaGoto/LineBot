package com.example.demo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.linecorp.bot.client.LineMessagingClient;
import com.linecorp.bot.model.Multicast;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.model.response.BotApiResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PushService {

	@Autowired
	LineMessagingClient lineMessagingClient;
	@Autowired
	IndividualDaoJdbc individualDao;

	public void pushMessage(String message) {

		try {

	    	TextMessage textMessage = new TextMessage(message);

	    	List<String> getList = individualDao.getLineMember();
	    	Set<String> lineMember = new HashSet<String>(getList);
	    	Multicast multicast = new Multicast(lineMember, textMessage);
	    	BotApiResponse response = lineMessagingClient.multicast(multicast).get();

	    	//PushMessage pushMessage = new PushMessage("U3ffa70b26534f3f36f59c17b82e7295d", textMessage);
	    	//BotApiResponse response = lineMessagingClient.pushMessage(pushMessage).get();

	      System.out.println(response);

	    } catch (InterruptedException | ExecutionException e) {
	      throw new RuntimeException(e);
	    }

	}

}
