package com.epam.spring.core;

import java.util.Map;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	Client client;
//	CacheFileEventLogger eventLogger;
	EventLogger defaultLogger;
	Map<EventType, EventLogger> loggers;
	static Event event;

	public static void main(String[] args) {
		
		ConfigurableApplicationContext ctx = 
				new ClassPathXmlApplicationContext("spring.xml");
		App app = (App) ctx.getBean("app");
		app.logEvent(EventType.ERROR, event, "Some event for 1");
//		app.logEvent(EventType.INFO, event, "Some event for 1");
//		app.logEvent("Some event for user 2");
		ctx.close();
	}

	public App(Client client, EventLogger eventLogger,
			Map<EventType, EventLogger> loggers, Event event) {
		super();
		this.client = client;
		this.defaultLogger = eventLogger;
		this.loggers = loggers;
		App.event = event;
	}

	 private void logEvent(EventType eventType, Event event, String msg) {
	        String message = msg.replaceAll(client.getId(), client.getFullName());
	        event.setMsg(message);
	        
	        EventLogger logger = loggers.get(eventType);
	        if (logger == null) {
	            logger = defaultLogger;
	        }
	        
	        logger.logEvent(event);
	    }
	 
	public EventLogger getDefaultLogger() {
        return defaultLogger;
    }
}
