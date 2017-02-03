package me.foly.si.game;

import me.foly.si.GameApplet;
import me.foly.si.domain.general.GModel;
import me.foly.si.domain.general.GObject;
import me.foly.si.domain.general.GView;
import processing.event.KeyEvent;

public class Game {
    private final GameModel model;
    private final GameView view;

    public Game(GameApplet ga) {
        this.model = new GameModel();
        this.view = new GameView(model, ga);

        GModel objModel = new GModel(0, 0, 100, 100);
        GView objView = new GView(ga);
        GObject obj = new GObject(objModel, objView);

        model.addObject(obj);
    }

    public void step() {
        model.getObjects().forEach(GObject::step);
    }

    public void draw() {
        view.draw();
    }

    public void keyPressed(KeyEvent event) {

    }

    public void keyReleased(KeyEvent event) {

    }
}
