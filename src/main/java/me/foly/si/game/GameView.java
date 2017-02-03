package me.foly.si.game;

import me.foly.si.GameApplet;
import me.foly.si.domain.general.GObject;

import static processing.core.PConstants.RIGHT;
import static processing.core.PConstants.TOP;

public class GameView {
    private final GameModel model;
    private final GameApplet applet;

    public GameView(GameModel model, GameApplet applet) {
        this.model = model;
        this.applet = applet;
    }

    public void draw() {
        applet.background(0);

        model.getObjects().forEach(GObject::draw);

        //TODO: remove this
        applet.fill(255);
        applet.textAlign(RIGHT, TOP);
        applet.textSize(32);
        applet.text(model.getObjects().size(), GameApplet.WIDTH, 0);
    }
}
