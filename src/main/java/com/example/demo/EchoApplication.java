package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.linecorp.bot.model.event.FollowEvent;
import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.UnfollowEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.spring.boot.annotation.EventMapping;
import com.linecorp.bot.spring.boot.annotation.LineMessageHandler;

@SpringBootApplication
@LineMessageHandler
public class EchoApplication {

	@Autowired
	PushService pushService;
	@Autowired
	IndividualService individualService;

	public static void main(String[] args) {
        SpringApplication.run(EchoApplication.class, args);
    }

    @EventMapping
    public TextMessage handleTextMessageEvent(MessageEvent<TextMessageContent> event) {
        System.out.println("event: " + event);
        String msg = event.getMessage().getText();

        if (msg.equals("userid") ) {
        	pushService.pushMessage(event.getSource().getUserId());
        	return new TextMessage( event.getSource().getUserId() );
        }
        return null;
    }

    @EventMapping
    public TextMessage handleFollowEvent(FollowEvent event) {

    	individualService.insert(event.getSource().getUserId());
        return new TextMessage("ラビータの開催案内をお知らせします");
    }

    public TextMessage handleUnfollowEvent(UnfollowEvent event) {

    	individualService.delete(event.getSource().getUserId());
        return new TextMessage("またよろしく！");
    }

}
