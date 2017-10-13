package me.foly.si.core.scene;

import me.foly.si.core.Game;
import me.foly.si.core.IDrawer;
import me.foly.si.core.misc.InputKey;
import me.foly.si.core.ship.IShip;
import me.foly.si.core.ship.Player;
import me.foly.si.core.ship.ShipFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static me.foly.si.core.SiConstants.*;

public class StageScene implements IScene {
    private List<IShip> ships = new ArrayList<>();
    private Player player;

    public StageScene() {
        player = new Player();
        this.addShips(
                player,
                ShipFactory.createEnemy1(GAME_LEFT, GAME_TOP),
                ShipFactory.createEnemy1(GAME_RIGHT, GAME_TOP + 60)
        );
    }

    public void addShips(IShip... shipsToAdd) {
        Collections.addAll(ships, shipsToAdd);
    }

    @Override
    public void tick(Game game) {
        ships.forEach(IShip::tick);
    }

    public void draw(IDrawer drawer) {
        drawer.background("bg.jpg");
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
            case P:
                game.setScene(new PauseScene(this));
                break;
        }
    }
}
