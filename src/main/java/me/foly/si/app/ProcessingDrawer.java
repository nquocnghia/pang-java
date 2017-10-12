package me.foly.si.app;

import me.foly.si.core.IAssetsManager;
import me.foly.si.core.IDrawer;
import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

import static processing.core.PConstants.*;

public class ProcessingDrawer implements IDrawer<PImage> {
    private PApplet applet;
    private IAssetsManager<PImage, PFont> assetsManager;

    public ProcessingDrawer(GameApplet applet, IAssetsManager<PImage, PFont> assetsManager) {
        this.applet = applet;
        this.assetsManager = assetsManager;
    }

    @Override
    public void background(String imgSrc) {
        applet.background(assetsManager.getAsset(imgSrc));
    }

    @Override
    public void fill(float r, float g, float b) {
        applet.fill(r, g, b);
    }

    @Override
    public void stroke(float r, float g, float b) {
        applet.stroke(r, g, b);
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

    @Override
    public void nofill() {
        applet.noFill();
    }

    @Override
    public void noStroke() {
        applet.noStroke();
    }

    @Override
    public void textAlign(int alignX, int alignY) {
        int x, y;

        switch (alignX) {
            case TEXT_LEFT:
                x = LEFT;
                break;
            case TEXT_RIGHT:
                x = RIGHT;
                break;
            case TEXT_CENTER:
                x = CENTER;
                break;
            default:
                x = LEFT;
        }

        switch (alignY) {
            case TEXT_TOP:
                y = TOP;
                break;
            case TEXT_CENTER:
                y = CENTER;
                break;
            case TEXT_BOTTOM:
                y = BOTTOM;
                break;
            case TEXT_BASELINE:
                y = BASELINE;
                break;
            default:
                y = TOP;
        }

        applet.textAlign(x, y);
    }

    @Override
    public void textFont(String fontName, int size) {
        applet.textFont(assetsManager.getFont(fontName), size);
    }

    @Override
    public void text(String text, float x, float y) {
        applet.text(text, x, y);
    }

    @Override
    public void textSize(float size) {
        applet.textSize(size);
    }
}
