package me.foly.si.core.ship;

public class ShipFactory {
    public static Ship createEnemy1(int left, int top) {
        return new SimpleEnemy("enemyBlack1.png", left, top, 53, 48);
    }
}
