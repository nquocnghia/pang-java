package me.foly.si.core.ship;

public class ShipFactory {
    public static Player makePlayer() {
        return new Player();
    }

    public static Ship makeEnemy1(int left, int top) {
        return new SimpleEnemy("enemyBlack1.png", left, top, 53, 48);
    }

    public static SimpleBullet makeBullet1(IShip shooter) {
        return new SimpleBullet(shooter);
    }
}
