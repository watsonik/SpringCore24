package com.epam.spring.core;

import java.util.ArrayList;
import java.util.List;

public class CacheFileEventLogger extends FileEventLogger {

	int cacheSize;
	List<Event> cache;

	public CacheFileEventLogger(String filename, int cacheSize) {
		super(filename);
		this.cacheSize = cacheSize;
		this.cache = new ArrayList<Event>(cacheSize);
	}

	public void logEvent(Event event) {
		cache.add(event);

		if (cache.size() == cacheSize) {
			writeEventsFromCache();
			cache.clear();
		}
	}

	private void writeEventsFromCache() {
		cache.stream().forEach(super::logEvent);
	}
	
	public void destroy(){
		if (!cache.isEmpty())
			writeEventsFromCache();
	}
}
