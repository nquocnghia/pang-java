package me.foly.si.core.ship;

import static me.foly.si.core.SiConstants.*;

public class SimpleBullet extends Ship {
	
	private final static int DELTA = 2;
	private int deltaY = 0;
	private IShip shooter;

	public SimpleBullet(IShip shooter) {
		super("", 0, 0, 0, 0);
		
		this.shooter = shooter;
		
		if (shooter.getBottom() == GAME_BOTTOM)
			deltaY = DELTA;
		else
			deltaY = -DELTA;

		getModel().setCenterX(shooter.getCenterX());
		
		if (deltaY > 0)
			getModel().setTop(shooter.getBottom());
		else 
			getModel().setBottom(shooter.getTop());
	}

	@Override
	public void tick() {
		getModel().getPosition().translateY(deltaY);
	}

	@Override
	public ShipType getType() {
		return shooter.getType();
	}

}
