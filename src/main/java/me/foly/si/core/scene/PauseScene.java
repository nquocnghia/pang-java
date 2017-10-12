package me.foly.si.core.scene;

import me.foly.si.core.Game;
import me.foly.si.core.IDrawer;
import me.foly.si.core.misc.InputKey;

import static me.foly.si.core.SiConstants.*;

public class PauseScene implements IScene {
    private StageScene currentScene;

    public PauseScene(StageScene currentScene) {
        this.currentScene = currentScene;
    }

    @Override
    public void tick(Game game) {

    }

    @Override
    public void draw(IDrawer drawer) {
        drawer.fill(0, 0, 0);
        drawer.rect(0, 0, CANVAS_WIDTH, CANVAS_HEIGHT);

        drawer.fill(255, 255, 255);
        drawer.textAlign(IDrawer.TEXT_CENTER, IDrawer.TEXT_CENTER);
        drawer.textFont("future.ttf", 30);
        drawer.text("PAUSED", GAME_CENTER_X, GAME_CENTER_Y);
    }

    @Override
    public void keyReleased(InputKey key, Game game) {

    }

    @Override
    public void keyPressed(InputKey key, Game game) {
        if (key == InputKey.P) {
            game.setScene(currentScene);
        }
    }
}
