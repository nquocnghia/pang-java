package me.foly.si.core.ship;

import me.foly.si.core.misc.InputKey;

import static me.foly.si.core.SiConstants.*;

public class Player extends Ship {
    private static final int DELTA = 5;

    private int deltaX = 0;

    public Player() {
        super("player_ship.png", 0, 0, 64, 48);
        getModel().setCenterX(GAME_CENTER_X);
        getModel().setBottom(GAME_BOTTOM);
    }

    public void move(InputKey key) {
        switch (key) {
            case LEFT:
                this.deltaX = -DELTA;
                break;
            case RIGHT:
                this.deltaX = DELTA;
                break;
            case UP:
                break;
            case DOWN:
                break;
        }
    }

    public void stop(InputKey key) {
        if ((key == InputKey.LEFT && deltaX < 0) || (key == InputKey.RIGHT && deltaX > 0))
            this.deltaX = 0;
    }

    @Override
    public void tick() {
        getModel().getPosition().translateX(deltaX);
        if (getLeft() <= GAME_LEFT && deltaX < 0)
            getModel().setLeft(GAME_LEFT);
        else if (getRight() >= GAME_RIGHT && deltaX > 0)
            getModel().setRight(GAME_RIGHT);
    }

	@Override
	public ShipType getType() {
		return ShipType.PLAYER;
	}
	
	@Override
	public int getBottom() {
		return GAME_BOTTOM;
	}
    
}
