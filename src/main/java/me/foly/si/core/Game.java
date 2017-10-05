package me.foly.si.core;

import me.foly.si.core.misc.InputKey;
import me.foly.si.core.scene.IScene;
import me.foly.si.core.scene.StageScene;

public class Game {
    private IScene currentScene;
    private IDrawer drawer;

    public Game(IDrawer drawer) {
        this.drawer = drawer;
        currentScene = new StageScene();
    }

    public void tick() {
        currentScene.tick(this);
    }

    public void draw() {
        currentScene.draw(drawer);
    }

    public void keyPressed(InputKey key) {
        currentScene.keyPressed(key, this);
    }

    public void keyReleased(InputKey key) {
        currentScene.keyReleased(key, this);
    }

    public void setScene(IScene currentScene) {
        this.currentScene = currentScene;
    }
}
