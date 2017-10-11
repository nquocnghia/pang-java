package me.foly.si.core.ship;

import me.foly.si.core.IDrawer;

public interface IShip {
    void tick();

    void draw(IDrawer drawer);

    ShipView getView();

    ShipModel getModel();

    int getLeft();

    int getTop();

    int getRight();

    int getBottom();

    int getWidth();

    int getHeight();

    int getCenterX();

    int getCenterY();
    
    ShipType getType();
}
