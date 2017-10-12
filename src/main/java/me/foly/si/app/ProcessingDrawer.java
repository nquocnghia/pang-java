package me.foly.si.app;

import me.foly.si.core.IAssetsManager;
import me.foly.si.core.IDrawer;
import processing.core.PApplet;
import processing.core.PImage;

public class ProcessingDrawer implements IDrawer<PImage> {
    private PApplet applet;
    private IAssetsManager<PImage> assetsManager;

    public ProcessingDrawer(GameApplet applet, IAssetsManager<PImage> assetsManager) {
        this.applet = applet;
        this.assetsManager = assetsManager;
    }

    @Override
    public void background(String imgSrc) {
        applet.background(assetsManager.getAsset(imgSrc));
    }

    @Override
    public void background(float r, float g, float b) {
        applet.background(r, g, b);
    }

    @Override
    public void rect(int left, int top, int width, int height) {
        applet.rect(left, top, width, height);
    }

    @Override
    public void image(String imgSrc, int x, int y, int width, int height) {
        applet.image(assetsManager.getAsset(imgSrc), x, y, width, height);
    }
}
