package com.framework.logic;

import java.awt.Shape;


/**
 * @author Hans
 * @version 1.0
 * @created 25-Mrz-2013 09:54:25
 */
public class Player extends Entity {

	Level level;
	String name;

	public Player(String name, int tuioSymbolID, Level level) {
		this.name = name;
		this.level = level;
	}

	@Override
	public void update(float gap) {
		
		switch (level.getState()) {
		case PREPARE:

			setChanged();
			break;
		case STARTED:

			setChanged();
			break;
		case ENDED:

			setChanged();
			break;
		default:
			break;
		}
	}

	@Override
	public void createCollision(Shape shape) {
		
	}

}// end Player