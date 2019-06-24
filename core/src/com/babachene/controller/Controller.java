package com.babachene.controller;

public abstract class Controller {
	
	public Controller() {
		
	}
	
	public abstract void update();
	
	public abstract void launchLevel(Object arg);
	
	public abstract void close();	
}
