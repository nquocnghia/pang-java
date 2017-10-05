package me.foly.si.core.scene;

import me.foly.si.core.Game;
import me.foly.si.core.IDrawer;
import me.foly.si.core.ship.IShip;
import me.foly.si.core.ship.Player;
import me.foly.si.core.misc.InputKey;

import java.util.ArrayList;
import java.util.List;

import static me.foly.si.core.SiConstants.CANVAS_HEIGHT;
import static me.foly.si.core.SiConstants.CANVAS_WIDTH;

public class StageScene implements IScene {
    List<IShip> ships = new ArrayList<>();
    private Player player;

    public StageScene() {
        player = new Player();
        ships.add(player);
    }

    @Override
    public void tick(Game game) {
        ships.forEach(IShip::tick);
    }

    public void draw(IDrawer drawer) {
        drawer.image("bg.jpg", 0, 0, CANVAS_WIDTH, CANVAS_HEIGHT);
        ships.forEach(o -> o.draw(drawer));
    }

    @Override
    public void keyReleased(InputKey key, Game game) {
        switch (key) {
            case UP:
            case DOWN:
            case LEFT:
            case RIGHT:
                player.stop(key);
                break;
        }
    }

    @Override
    public void keyPressed(InputKey key, Game game) {
        switch (key) {
            case UP:
            case DOWN:
            case LEFT:
            case RIGHT:
                player.move(key);
                break;
        }
    }
}
