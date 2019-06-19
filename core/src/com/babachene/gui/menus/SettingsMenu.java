package com.babachene.gui.menus;

import com.babachene.gui.BabaIsUs;
import com.babachene.gui.GameState;
import com.babachene.gui.MainGame;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class SettingsMenu extends GameState implements Screen {

	private MainGame parent;
	
	private Stage stage;
	private TextField title;
	private TextButton backButton;
	
	public SettingsMenu(MainGame game) {
		parent=game;
		
		stage = new Stage(getViewport());
		
		
		// Title
		title = new TextField("Settings", BabaIsUs.skin);
		title.setY(900);
		title.setX(900);
		stage.addActor(title);
		
		
		//BackButton
		backButton = new TextButton("back", BabaIsUs.skin);
		backButton.setBounds(100, 80, 120, 80);
		backButton.setColor(BabaIsUs.buttonColor);

		backButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				System.out.println("back Button pressed");
				
				parent.back();
				
				return; // The event has been handled.
			}
		});
		backButton.setDisabled(false);
		stage.addActor(backButton);
		
		
		
		
		
		Gdx.input.setInputProcessor(stage);
		
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(.1f, .05f, .01f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		stage.act();
		stage.draw();
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		Gdx.input.setInputProcessor(stage);
		
	}

	@Override
	public void hide() {}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		
	}

}
