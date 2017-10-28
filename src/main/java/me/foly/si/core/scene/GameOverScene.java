package me.foly.si.core.scene;

import me.foly.si.core.Game;
import me.foly.si.core.IDrawer;
import me.foly.si.core.misc.InputKey;

import static me.foly.si.core.SiConstants.*;

public class GameOverScene implements IScene {
    private final int INTERVAL = FPS / 2;
    private final int MARGIN = 5;

    private int counter = 0;
    private boolean isShown = true;

    @Override
    public void tick(Game game) {
        if (counter++ == INTERVAL) {
            counter = 0;
            isShown = !isShown;
        }
    }

    @Override
    public void draw(IDrawer drawer) {
        drawer.background(0, 0, 0);
        drawer.fill(255, 255, 255);
        drawer.textFont("future.ttf", 30);
        drawer.textAlign(IDrawer.TEXT_CENTER, IDrawer.TEXT_BOTTOM);
        drawer.text("GAME OVER", GAME_CENTER_X, GAME_CENTER_Y - MARGIN);

        // make it blink
        if (isShown) {
            drawer.textSize(15);
            drawer.textAlign(IDrawer.TEXT_CENTER, IDrawer.TEXT_TOP);
            drawer.text("Press any key to return to the menu...", GAME_CENTER_X, GAME_CENTER_Y + MARGIN);
        }
    }

    @Override
    public void keyReleased(InputKey key, Game game) {

    }

    @Override
    public void keyPressed(InputKey key, Game game) {
        game.setScene(new MenuScene());
    }
}
