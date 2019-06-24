package com.babachene.controller;

import java.util.Observable;
import java.util.Observer;
import java.util.logging.Logger;

import com.babachene.cliserv.Update;
import com.babachene.game.SoloController;
import com.babachene.gui.MainGame;
import com.babachene.logic.data.LevelMap;

public final class MetaController implements Observer {
	
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	/** MetaController handles a controller. */
	private Controller controller;
	private MainGame game;
	
	////////////////////////////////////
	
	public MetaController(MainGame game) {
		this.game = game;
	}
	
	////////////////////////////////////
	
	public void update() {
		if (controller != null)
			controller.update();
	}
	
	public void launchLevel(LevelMap level) { // TODO change the argument
		// TODO Maybe do here some checking in case another level is running.
		if (controller != null)
			controller.launchLevel(null);
		else
			(controller = new SoloController(game)).launchLevel(null);
	}

	public void joinServer(String ip, int parseInt) {
		controller.close();
		controller = new ClientEventController(game, ip, parseInt);
	}

	public void hostServer(int parseInt) {
		controller.close();
		controller = new ServerEventController(game, parseInt, 10);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		LOGGER.info("[Game Controller] Connection failed, or disconnected from server");
		
		// TODO complete
	}

	public void notifyUpdate(Update update) {
		
	}
	
}
