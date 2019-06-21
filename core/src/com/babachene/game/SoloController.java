package com.babachene.game;

import com.babachene.cliserv.InputEvent;
import com.babachene.gui.LevelState;
import com.babachene.gui.MainGame;
import com.babachene.logic.GameLogic;
import com.babachene.logic.data.LevelMap;
import com.babachene.userinput.EventGiver;
import com.babachene.userinput.KeyboardMap;
import com.babachene.userinput.LevelInputProcessor;
import com.badlogic.gdx.Input.Keys;

/**
 * A controller for a solo game with no client / server tempering.
 * @author jeremy
 *
 */
public class SoloController extends Controller {
	
	private MainGame mainGame;
	private GameLogic logic;
	private EventGiver giver;
	private LevelInputProcessor inputProcessor;
	
	public SoloController(MainGame mainGame) {
		if (mainGame == null)
			throw new IllegalArgumentException("MainGame cannot be null.");
		this.mainGame = mainGame;
		giver = new EventGiver();
		inputProcessor = new LevelInputProcessor(new KeyboardMap(Keys.Z, Keys.S, Keys.Q, Keys.D, 5, 6, 7, 8,
													Keys.UP, Keys.DOWN, Keys.LEFT, Keys.RIGHT), giver);
		
		// No creation of logic, map. It's in launchLevel
	}
	
	@Override
	public void launchLevel(Object arg) {
		/*
		 * TEST ZONE : Create a custom map for testing.
		 */
		
		LevelMap map = new LevelMap(10, 10);
		
		map.addEntity(2, 4, "baba");
		map.addEntity(5, 5, "textis");
		map.addEntity(5, 8, "textbaba");
		map.addEntity(4, 2, "rock");
		map.addEntity(0, 0, "textbaba");
		map.addEntity(1, 0, "textis");
		map.addEntity(2, 0, "textyou");
		
		logic = new GameLogic(map);
		
		mainGame.push(new LevelState(map, inputProcessor));
	}
	
	public void update() {
		
		fetchEvent();
		
	}
	
	public void fetchEvent() {
		while (giver.size() != 0) {
			logic.processInput( (InputEvent) giver.pollEvent());
		}
	}
	
}
