package me.foly.si.core.ship;

import me.foly.si.core.event.EventShipCreated;
import me.foly.si.core.event.EventShipDestroyed;
import me.foly.si.core.event.GameEvent;
import me.foly.si.core.event.ISiObserver;
import me.foly.si.core.misc.InputKey;
import me.foly.si.core.ship.movestrategy.LinearMove;

import static me.foly.si.core.SiConstants.*;

public class Player extends Ship implements ISiObserver {
    private final static int DELTAX = 5;

    private SimpleBullet lastBullet;

    public Player() {
        super("player_ship.png", 0, 0, 64, 48, ShipType.PLAYER, new LinearMove(0, 0));
        getModel().setCenterX(GAME_CENTER_X);
        getModel().setBottom(GAME_BOTTOM);
    }

    public void move(InputKey key) {
        switch (key) {
            case LEFT:
                this.getMover().setDeltaX(-DELTAX);
                break;
            case RIGHT:
                this.getMover().setDeltaX(DELTAX);
                break;
        }
    }

    public void stop(InputKey key) {
        if ((key == InputKey.LEFT && this.getMover().getDeltaX() < 0) || (key == InputKey.RIGHT && this.getMover().getDeltaX() > 0))
            this.getMover().setDeltaX(0);
    }

    @Override
    public void tick() {
        super.tick();

        if (getLeft() <= GAME_LEFT && this.getMover().getDeltaX() < 0)
            getModel().setLeft(GAME_LEFT);
        else if (getRight() >= GAME_RIGHT && this.getMover().getDeltaX() > 0)
            getModel().setRight(GAME_RIGHT);
    }

    @Override
    public boolean canCollideWith(IShip that) {
        return that instanceof SimpleBullet && that.getType() == ShipType.ENEMY;
    }

    @Override
    public void collidedWith(IShip that) {

    }

    public void shoot() {
        if (this.lastBullet == null) {
            this.lastBullet = ShipFactory.makeBullet1(this);
            this.lastBullet.attach(this);
            this.notify(new EventShipCreated(this, this.lastBullet));
        }
    }

    @Override
    public void update(GameEvent event) {
        if (event instanceof EventShipDestroyed) {
            IShip destroyedShip = ((EventShipDestroyed) event).getDestroyedShip();
            if (destroyedShip == this.lastBullet) {
                this.lastBullet = null;
            }
        }
    }

    @Override
    public LinearMove getMover() {
        return (LinearMove) super.getMover();
    }
}
