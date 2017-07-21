package com.epam.spring.core;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	Client client;
//	CacheFileEventLogger eventLogger;
	ConsoleEventLogger eventLogger;
	static Event event;

	public static void main(String[] args) {
		
		ConfigurableApplicationContext ctx = 
				new ClassPathXmlApplicationContext("spring.xml");
		App app = (App) ctx.getBean("app");
		app.logEvent(event);
//		app.logEvent("Some event for user 2");
		ctx.close();
	}

	public App(Client client, ConsoleEventLogger eventLogger, Event event) {
		super();
		this.client = client;
		this.eventLogger = eventLogger;
		this.event = event;
	}

	void logEvent(Event msg) {
//		String message = msg.replaceAll(client.getId(), client.getFullName());
		eventLogger.logEvent(msg);
//		String message = msg.replaceAll(client.getId(), client.getFullName());
//		eventLogger.logEvent(message);
	}
}
