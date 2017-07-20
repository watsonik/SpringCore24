package com.epam.spring.core;

public class App {
	Client client;
	ConsoleEventLogger eventLogger;

	public static void main(String[] args) {
		App app = new App();
		app.client = new Client("1", "Johm Smith");
		app.eventLogger = new ConsoleEventLogger();
		app.logEvent("Some event for user 1");
	}

	void logEvent(String msg) {
		String message = msg.replaceAll(client.getId(), client.getFullName());
		eventLogger.logEvent(message);
	}
}
