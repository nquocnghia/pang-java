package me.foly.si.core.ship;

import me.foly.si.core.event.EventShipDestroyed;
import me.foly.si.core.ship.movestrategy.BounceMove;

public class SimpleEnemy extends Ship {

    private static int DELTA = 3;

    public SimpleEnemy(String imgSrc, int left, int top, int width, int height) {
        super(imgSrc, left, top, width, height, ShipType.ENEMY, new BounceMove(DELTA, 0));
    }

    @Override
    public ShipType getType() {
        return ShipType.ENEMY;
    }

    @Override
    public boolean canCollideWith(IShip that) {
        return that instanceof SimpleBullet && that.getType() == ShipType.PLAYER;
    }

    @Override
    public void collidedWith(IShip that) {
        this.notify(new EventShipDestroyed(this, this));
    }

}
