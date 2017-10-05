package me.foly.si.core;

public interface IDrawer<T> {
    void background(float r, float g, float b);

    void rect(int left, int top, int width, int height);

    void image(String imgSrc, int x, int y, int width, int height);
}
