package me.foly.si.core.ship;

import me.foly.si.core.event.EventShipDestroyed;
import me.foly.si.core.ship.movestrategy.LinearMove;

import static me.foly.si.core.SiConstants.CANVAS_HEIGHT;
import static me.foly.si.core.SiConstants.GAME_BOTTOM;

public class SimpleBullet extends Ship {

    private final static int DELTA = 5;
    private IShip shooter;

    public SimpleBullet(IShip shooter) {
        super("laserBlue01.png", 0, 0, 5, 32, shooter.getType(), new LinearMove(0, 0));

        this.shooter = shooter;

        if (shooter.getBottom() == GAME_BOTTOM) {
            getMover().setDeltaY(-DELTA);
            getModel().setBottom(shooter.getTop());
        } else {
            getMover().setDeltaY(DELTA);
            getModel().setTop(shooter.getBottom());
        }

        getModel().setCenterX(shooter.getCenterX());
    }

    @Override
    public void tick() {
        if (getBottom() <= 0 || getTop() >= CANVAS_HEIGHT)
            this.selfDestroy();
        else
            super.tick();
    }

    private void selfDestroy() {
        this.notify(new EventShipDestroyed(this, this));
    }

    @Override
    public ShipType getType() {
        return shooter.getType();
    }

    @Override
    public boolean canCollideWith(IShip that) {
        return that.getType() != this.getType();
    }

    @Override
    public void collidedWith(IShip that) {
        this.notify(new EventShipDestroyed(this, this));
    }

    @Override
    public LinearMove getMover() {
        return (LinearMove) super.getMover();
    }
}
