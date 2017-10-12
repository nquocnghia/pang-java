package me.foly.si.core;

public interface IDrawer<T> {
    int TEXT_LEFT = 1;
    int TEXT_CENTER = 2;
    int TEXT_RIGHT = 3;
    int TEXT_TOP = 4;
    int TEXT_BOTTOM = 5;
    int TEXT_BASELINE = 6;

    void fill(float r, float g, float b);

    void stroke(float r, float g, float b);

    void background(String imgSrc);

    void background(float r, float g, float b);

    void rect(int left, int top, int width, int height);

    void image(String imgSrc, int x, int y, int width, int height);

    void nofill();

    void noStroke();

    void textAlign(int alignX, int alignY);

    void textFont(String fontName, int size);

    void text(String text, float x, float y);

    void textSize(float size);
}
