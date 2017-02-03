package me.foly.si;

import me.foly.si.game.Game;
import processing.core.PApplet;
import processing.event.KeyEvent;

public class GameApplet extends PApplet {
    public static final int WIDTH = 800, HEIGHT = 600;
    int x = 0;
    private Game game;

    public static void main(String[] args) {
        PApplet.main("me.foly.si.GameApplet");
    }

    @Override
    public void setup() {
        frameRate(60);
        game = new Game(this);
    }

    @Override
    public void keyPressed(KeyEvent event) {
        game.keyPressed(event);
    }

    @Override
    public void keyReleased(KeyEvent event) {
        game.keyReleased(event);
    }

    @Override
    public void draw() {
        game.step();
        game.draw();
    }

    @Override
    public void settings() {
        size(WIDTH, HEIGHT);
    }
}
