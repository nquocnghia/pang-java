package me.foly.si.core.ship;

import static me.foly.si.core.SiConstants.*;

public class SimpleEnemy extends Ship {
	
	private static int DELTA = 3;
	private int deltaX = DELTA; 

	public SimpleEnemy() {
		super("player_ship.png", 0, 0, 64, 48);
		getModel().setCenterX(GAME_CENTER_X);
		getModel().setTop(GAME_TOP);
	}

	@Override
	public void tick() {
		if(getLeft() <= 0 && deltaX < 0) {
			getModel().setLeft(GAME_LEFT);
			deltaX = DELTA; 
		}
		else if (getWidth() + getLeft() >= GAME_WIDTH && deltaX > 0) {
			getModel().setRight(GAME_RIGHT);
			deltaX = -DELTA;
		}
		
		getModel().getPosition().translateX(deltaX);
	}

	@Override
	public ShipType getType() {
		return ShipType.ENEMY;
	}

}
