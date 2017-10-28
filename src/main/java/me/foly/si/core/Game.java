package me.foly.si.core;

import me.foly.si.core.misc.InputKey;
import me.foly.si.core.scene.IScene;
import me.foly.si.core.scene.LoadingScene;

public class Game {
    private final IAssetsManager assetsManager;
    private final IDrawer drawer;
    private IScene currentScene;

    public Game(IAssetsManager assetsManager, IDrawer drawer) {
        this.drawer = drawer;
        this.assetsManager = assetsManager;
        currentScene = new LoadingScene(assetsManager);
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

    public IScene getScene() {
        return currentScene;
    }

    public IAssetsManager getAssetsManager() {
        return assetsManager;
    }

    public IDrawer getDrawer() {
        return drawer;
    }
}
