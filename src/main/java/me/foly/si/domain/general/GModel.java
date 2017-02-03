package me.foly.si.domain.general;

import me.foly.si.misc.Position;
import me.foly.si.misc.Size;

public class GModel {
    private Position position;
    private Size size;

    public GModel(int x, int y, int width, int height) {
        this(new Position(x, y), new Size(width, height));
    }

    public GModel(Position position, Size size) {
        this.position = position;
        this.size = size;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public int getWidth() {
        return this.size.getWidth();
    }

    public int getHeight() {
        return this.size.getHeight();
    }

    public int getLeft() {
        return this.position.getX();
    }

    public int getRight() {
        return this.position.getX() + this.size.getWidth();
    }

    public int getTop() {
        return this.position.getY();
    }

    public int getBottom() {
        return this.position.getY() + this.size.getHeight();
    }
}
