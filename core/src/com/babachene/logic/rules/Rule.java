package com.babachene.logic.rules;

import java.util.LinkedList;

import com.babachene.logic.data.Entity;
import com.babachene.logic.data.LevelGroupOfEntities;
import com.babachene.logic.data.LevelMap;

public class Rule {

	private Subject subject;
	private Attribute attribute;
	private Verb verb;
	private RulesUpdater rulesUpdater;
	
	public Rule(Subject subject, Attribute attribute, Verb verb, RulesUpdater rulesUpdater) {
		super();
		this.subject = subject;
		this.attribute = attribute;
		this.verb = verb;
		this.rulesUpdater = rulesUpdater;
	}
	
	public void applyRules() {
		for (Text text:subject.getSubjectList())
		{
			applyNounRule(text,attribute.getNounList());
			for (Text property:attribute.getPropertyList())
				applyPropertyRule(text,property);
		}
		
	}
	

	private void applyPropertyRule(Text text, Text property) {
		rulesUpdater.getMap();
		LevelGroupOfEntities entities = LevelMap.findGroup(text.getText());
		if (entities != null) {
		if (this.verb.getText().equalsIgnoreCase("is")){
		switch(property.getText())
		{
		case("sink"):
			entities.setIsSink(true);
			break;
		case("win"):
			entities.setIsWin(true);
			break;
		case("block"):
			entities.setIsBlock(true);
			break;
		case("push"):
			entities.setIsPush(true);
			break;
		case("you"):
			entities.setIsYou(true);
			break;
		case("p1"):
			entities.setIsPlayer1(true);
			break;
		case("p2"):
			entities.setIsPlayer2(true);
			break;
		}
		}
		}
	}

	private void applyNounRule(Text text, LinkedList<Text> nounList) {
		rulesUpdater.getMap();
		if (!nounList.isEmpty()) {
		LevelGroupOfEntities entities = LevelMap.findGroup(text.getText());
		if (entities != null) {
			LinkedList<Entity> list = entities.getListOfEntities();
			int n = list.size();
			for (int i = n-1; i> -1; i--) {
				Entity entity = list.get(i);
				int x = entity.getxPosition();
				int y = entity.getyPosition();
				for (Text noun : nounList)
					this.rulesUpdater.getMap().addEntity(x, y, noun.getText());
				this.rulesUpdater.getMap().removeEntity(entity);
			}
		}
	}}
	
}
