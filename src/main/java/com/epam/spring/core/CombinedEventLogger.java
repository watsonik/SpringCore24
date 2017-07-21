package com.epam.spring.core;

import java.util.Collection;
import java.util.Collections;

public class CombinedEventLogger implements EventLogger{
	Collection<EventLogger> loggers;
	
	public CombinedEventLogger(Collection<EventLogger> loggers) {
		super();
		this.loggers = loggers;
	}
	
	@Override
	public void logEvent(Event event) {
		for (EventLogger eventLogger : loggers) {
			eventLogger.logEvent(event);
		}
	}
	
	 public Collection<EventLogger> getLoggers() {
	        return Collections.unmodifiableCollection(loggers);
	    }

}
