package me.foly.si.core.ship.movestrategy;

import me.foly.si.core.ship.IShip;

public class LinearMove implements IMoveStrategy {
    protected int deltaX;
    protected int deltaY;

    public LinearMove(int deltaX, int deltaY) {
        this.deltaX = deltaX;
        this.deltaY = deltaY;
    }

    public int getDeltaX() {
        return deltaX;
    }

    public void setDeltaX(int deltaX) {
        this.deltaX = deltaX;
    }

    public int getDeltaY() {
        return deltaY;
    }

    public void setDeltaY(int deltaY) {
        this.deltaY = deltaY;
    }

    @Override
    public void move(IShip ship) {
        ship.getModel().getPosition().translate(deltaX, deltaY);
    }
}
