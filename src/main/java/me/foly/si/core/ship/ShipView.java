package me.foly.si.core.ship;

import me.foly.si.core.IDrawer;

public class ShipView {
    private String imgSrc;
    private ShipModel model;

    public ShipView(String imgSrc, ShipModel model) {
        this.imgSrc = imgSrc;
        this.model = model;
    }

    public void draw(IDrawer drawer) {
        drawer.image(imgSrc, model.getLeft(), model.getTop(), model.getWidth(), model.getHeight());
    }
}
