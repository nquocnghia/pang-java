package me.foly.si.app;

import me.foly.si.core.Game;
import me.foly.si.core.misc.InputKey;
import processing.core.PApplet;
import processing.event.KeyEvent;

import static me.foly.si.core.SiConstants.*;

public class GameApplet extends PApplet {
    private Game game;

    public static void main(String[] args) {
        PApplet.main("me.foly.si.app.GameApplet");
    }

    @Override
    public void setup() {
        frameRate(FPS);
        ProcessingAssetsManager assetsManager = new ProcessingAssetsManager(this);
        game = new Game(new ProcessingDrawer(this, assetsManager));
    }

    @Override
    public void settings() {
        size(CANVAS_WIDTH, CANVAS_HEIGHT);
    }

    @Override
    public void draw() {
        game.tick();
        game.draw();
    }

    @Override
    public void keyPressed(KeyEvent event) {
        if (event.getKey() == CODED) {
            switch (event.getKeyCode()) {
                case UP:
                    game.keyPressed(InputKey.UP);
                    break;
                case DOWN:
                    game.keyPressed(InputKey.DOWN);
                    break;
                case LEFT:
                    game.keyPressed(InputKey.LEFT);
                    break;
                case RIGHT:
                    game.keyPressed(InputKey.RIGHT);
                    break;
            }
        } else {
            switch (event.getKey()) {
                case ' ':
                    game.keyPressed(InputKey.SPACE);
                    break;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent event) {
        if (event.getKey() == CODED) {
            switch (event.getKeyCode()) {
                case UP:
                    game.keyReleased(InputKey.UP);
                    break;
                case DOWN:
                    game.keyReleased(InputKey.DOWN);
                    break;
                case LEFT:
                    game.keyReleased(InputKey.LEFT);
                    break;
                case RIGHT:
                    game.keyReleased(InputKey.RIGHT);
                    break;
            }
        } else {
            switch (event.getKey()) {
                case ' ':
                    game.keyReleased(InputKey.SPACE);
                    break;
            }
        }
    }
}
