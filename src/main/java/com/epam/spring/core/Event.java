package com.epam.spring.core;

import java.text.DateFormat;
import java.util.Date;
import java.util.Random;

public class Event {
	int id;// = new Random().nextInt(100);
	String msg;
	Date date;
	private DateFormat df;
	
	public Event(Date date, DateFormat df) {
		super();
		this.date = date;
		this.df = df;
		this.id = new Random().nextInt(100);
	}
	public Event() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Event [id=" + id + ", msg=" + msg + ", date=" + df.format(date) + "]";
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
