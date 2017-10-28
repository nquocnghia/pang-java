package me.foly.si.core.ship;

import me.foly.si.core.IDrawer;
import me.foly.si.core.event.SiObservable;
import me.foly.si.core.ship.movestrategy.IMoveStrategy;

public abstract class Ship extends SiObservable implements IShip {
    private ShipModel model;
    private ShipView view;
    private IMoveStrategy mover;

    public Ship(String imgSrc, int left, int top, int width, int height, ShipType type, IMoveStrategy mover) {
        this.model = new ShipModel(left, top, width, height, type);
        this.view = new ShipView(imgSrc, this.model);
        this.mover = mover;
    }

    public Ship(ShipModel model, ShipView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void tick() {
        this.mover.move(this);
    }

    @Override
    public void draw(IDrawer drawer) {
        view.draw(drawer);
    }

    @Override
    public ShipView getView() {
        return this.view;
    }

    @Override
    public ShipModel getModel() {
        return this.model;
    }

    @Override
    public int getLeft() {
        return model.getLeft();
    }

    @Override
    public void setLeft(int left) {
        model.setLeft(left);
    }

    @Override
    public int getTop() {
        return model.getTop();
    }

    @Override
    public void setTop(int top) {
        model.setTop(top);
    }

    @Override
    public int getRight() {
        return model.getRight();
    }

    @Override
    public void setRight(int right) {
        model.setRight(right);
    }

    @Override
    public int getBottom() {
        return model.getBottom();
    }

    @Override
    public void setBottom(int bottom) {
        model.setBottom(bottom);
    }

    @Override
    public int getCenterX() {
        return model.getCenterX();
    }

    @Override
    public void setCenterX(int centerX) {
        model.setCenterX(centerX);
    }

    @Override
    public int getCenterY() {
        return model.getCenterY();
    }

    @Override
    public void setCenterY(int centerY) {
        model.setCenterY(centerY);
    }

    @Override
    public int getWidth() {
        return model.getWidth();
    }

    @Override
    public void setWidth(int width) {
        model.setWidth(width);
    }

    @Override
    public int getHeight() {
        return model.getHeight();
    }

    @Override
    public void setHeight(int height) {
        model.setHeight(height);
    }

    @Override
    public ShipType getType() {
        return model.getType();
    }

    @Override
    public IMoveStrategy getMover() {
        return this.mover;
    }

    @Override
    public void setMover(IMoveStrategy mover) {
        this.mover = mover;
    }
}
