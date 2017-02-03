package me.foly.si.domain.general;

import me.foly.si.GameApplet;

public class GView {
    private GameApplet ga;

    public GView(GameApplet ga) {
        this.ga = ga;
    }

    public void draw(GModel model) {
        ga.rect(model.getLeft(), model.getTop(), model.getWidth(), model.getHeight());
    }
}
