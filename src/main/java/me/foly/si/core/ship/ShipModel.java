package me.foly.si.core.ship;

import me.foly.si.core.misc.Position;
import me.foly.si.core.misc.Size;

public class ShipModel {
    private Position position;
    private Size size;
    private ShipType type;

    public ShipModel(Position position, Size size, ShipType type) {
        this.position = position;
        this.size = size;
        this.type = type;
    }

    public ShipModel(int left, int top, int width, int height, ShipType type) {
        this(new Position(left, top), new Size(width, height), type);
    }

    public int getLeft() {
        return position.getX();
    }

    public void setLeft(int left) {
        position.setX(left);
    }

    public int getTop() {
        return position.getY();
    }

    public void setTop(int top) {
        position.setY(top);
    }

    public int getRight() {
        return position.getX() + size.getWidth() - 1;
    }

    public void setRight(int right) {
        position.setX(right - size.getWidth() + 1);
    }

    public int getBottom() {
        return position.getY() + size.getHeight() - 1;
    }

    public void setBottom(int bottom) {
        position.setY(bottom - size.getHeight() + 1);
    }

    public int getCenterX() {
        return position.getX() + size.getWidth() / 2;
    }

    public void setCenterX(int centerX) {
        position.setX(centerX - size.getWidth() / 2);
    }

    public int getCenterY() {
        return position.getY() + size.getHeight() / 2;
    }

    public void setCenterY(int centerY) {
        position.setY(centerY - size.getHeight() / 2);
    }

    public int getWidth() {
        return size.getWidth();
    }

    public void setWidth(int width) {
        size.setWidth(width);
    }

    public int getHeight() {
        return size.getHeight();
    }

    public void setHeight(int height) {
        size.setHeight(height);
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

    public ShipType getType() {
        return type;
    }

    public void setType(ShipType type) {
        this.type = type;
    }
}
