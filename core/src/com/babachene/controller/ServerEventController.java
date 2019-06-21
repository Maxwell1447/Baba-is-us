package com.babachene.controller;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.logging.Logger;

import com.babachene.cliserv.Event;
import com.babachene.cliserv.Server;
import com.babachene.cliserv.Update;
import com.babachene.game.GameController;
import com.babachene.logic.Logic;
import com.babachene.userinput.EventGiver;

public class ServerEventController {

	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	private GameController gameController;
	private Server server;
	private EventGiver eventGiver;
	private Logic logic;

	private ArrayBlockingQueue<Event> eventBuffer;
	private int eventBufferLength;
	private Update update;

    public ServerEventController(GameController gameController, Server server, EventGiver eventGiver, Logic logic, int eventBufferLength) {

		this.eventBufferLength = eventBufferLength;
		this.server = server;
		this.eventGiver = eventGiver;
		this.logic = logic;
        eventBuffer = new ArrayBlockingQueue<Event>(eventBufferLength);
        
		LOGGER.info("[Server Event Controller] Started");
	}

    private void addEvent(Event event) {
    	if(eventBuffer.size() < eventBufferLength)
    		eventBuffer.add(event);
    	else
    		LOGGER.warning("[Server Event Controller] Event buffer full, event dropped");
    }

    private void fetchEvents() {
        if(!server.isEventBufferEmpty()) {
    		LOGGER.fine("[Server Event Controller] Event received from server");
            Event event = server.getEvent();
    		event.setSource(1);
            addEvent(event);
        }
        if(eventGiver.size() > 0) {
    		LOGGER.fine("[Server Event Controller] Event received from input processor");
    		Event event = eventGiver.pollEvent();
    		event.setSource(0);
            addEvent(event);
        }
    }

    private boolean solveEvent() {
    	if(eventBuffer.size() > 0) {
    		LOGGER.fine("[Server Event Controller] Event sent to logic");
    		update = logic.processEvent(eventBuffer.poll());
    		return true;
    	}
    	return false;
    }

    private void sendUpdate() {
		LOGGER.fine("[Server Event Controller] Update sent to server");
    	server.addUpdate(update);
		LOGGER.fine("[Server Event Controller] Notified the game controller of the update");
		gameController.notifyUpdate(update);
    }

	public void update() {
		fetchEvents();
		if(solveEvent())
			sendUpdate();
    }
}