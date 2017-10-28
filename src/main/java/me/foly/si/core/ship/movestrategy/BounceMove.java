package me.foly.si.core.ship.movestrategy;

import me.foly.si.core.ship.IShip;

import static me.foly.si.core.SiConstants.*;

public class BounceMove extends LinearMove {
    private int boundLeft;
    private int boundRight;
    private int boundTop;
    private int boundBottom;

    public BounceMove(int deltaX, int deltaY, int boundLeft, int boundTop, int boundRight, int boundBottom) {
        super(deltaX, deltaY);

        this.boundLeft = boundLeft;
        this.boundRight = boundRight;
        this.boundTop = boundTop;
        this.boundBottom = boundBottom;
    }

    public BounceMove(int deltaX, int deltaY) {
        this(deltaX, deltaY, GAME_LEFT, GAME_TOP, GAME_RIGHT, GAME_BOTTOM);
    }

    @Override
    public void move(IShip ship) {
        super.move(ship);

        if (ship.getLeft() <= boundLeft) {
            ship.setLeft(boundLeft);
            this.deltaX *= -1;
        }

        if (ship.getRight() >= boundRight) {
            ship.setRight(boundRight);
            this.deltaX *= -1;
        }

        if (ship.getTop() <= boundTop) {
            ship.setTop(boundTop);
            this.deltaY *= -1;
        }

        if (ship.getBottom() >= boundBottom) {
            ship.setBottom(boundBottom);
            this.deltaY *= -1;
        }
    }
}
