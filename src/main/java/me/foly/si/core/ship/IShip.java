package me.foly.si.core.ship;

import me.foly.si.core.IDrawer;
import me.foly.si.core.event.ISiObservable;
import me.foly.si.core.ship.movestrategy.IMoveStrategy;

public interface IShip extends ISiObservable {
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

    void setLeft(int left);

    void setTop(int top);

    void setRight(int right);

    void setBottom(int bottom);

    void setWidth(int width);

    void setHeight(int height);

    void setCenterX(int centerX);

    void setCenterY(int centerY);

    boolean canCollideWith(IShip that);

    void collidedWith(IShip that);

    IMoveStrategy getMover();

    void setMover(IMoveStrategy mover);
}
