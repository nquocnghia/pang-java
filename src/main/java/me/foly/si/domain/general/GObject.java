package me.foly.si.domain.general;

import me.foly.si.GameApplet;

public class GObject {
    private GModel model;
    private GView view;

    //TODO: to improve
    private int veloX = 5;

    public GObject(GModel model, GView view) {
        this.model = model;
        this.view = view;
    }

    public void draw() {
        view.draw(model);
    }

    public void step() {
        model.getPosition().translateX(veloX);
        if ((model.getLeft() <= 0 && veloX < 0) || (model.getRight() >= GameApplet.WIDTH && veloX > 0))
            veloX *= -1;
    }
}
