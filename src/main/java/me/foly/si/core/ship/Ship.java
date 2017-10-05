package me.foly.si.core.ship;

import me.foly.si.core.IDrawer;

public abstract class Ship implements IShip {
    private ShipModel model;
    private ShipView view;

    public Ship(String imgSrc, int left, int top, int width, int height) {
        this.model = new ShipModel(left, top, width, height);
        this.view = new ShipView(imgSrc, this.model);
    }

    public Ship(ShipModel model, ShipView view) {
        this.model = model;
        this.view = view;
    }

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
    public int getTop() {
        return model.getTop();
    }

    @Override
    public int getRight() {
        return model.getRight();
    }

    @Override
    public int getBottom() {
        return model.getBottom();
    }

    @Override
    public int getCenterX() {
        return model.getCenterX();
    }

    @Override
    public int getCenterY() {
        return model.getCenterY();
    }

    @Override
    public int getWidth() {
        return model.getWidth();
    }

    @Override
    public int getHeight() {
        return model.getHeight();
    }
}
