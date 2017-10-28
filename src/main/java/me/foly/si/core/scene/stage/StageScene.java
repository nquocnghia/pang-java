package me.foly.si.core.scene.stage;

import me.foly.si.core.Game;
import me.foly.si.core.IDrawer;
import me.foly.si.core.event.EventShipCreated;
import me.foly.si.core.event.EventShipDestroyed;
import me.foly.si.core.event.GameEvent;
import me.foly.si.core.event.ISiObserver;
import me.foly.si.core.misc.InputKey;
import me.foly.si.core.scene.GameOverScene;
import me.foly.si.core.scene.IScene;
import me.foly.si.core.scene.PauseScene;
import me.foly.si.core.ship.IShip;
import me.foly.si.core.ship.Player;
import me.foly.si.core.ship.Ship;
import me.foly.si.core.ship.ShipFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static me.foly.si.core.SiConstants.*;
import static me.foly.si.core.scene.stage.StagePhase.*;
import static me.foly.si.core.ship.ShipType.ENEMY;

public class StageScene implements IScene, ISiObserver {
    private final int INTRO_DURATION = FPS * 2; // 2 seconds
    private final int ENDING_DURATION = FPS; // 1 second
    private int phaseCounter = 0;

    private List<IShip> ships = new ArrayList<>();
    private List<IShip> shipsToAdd = new ArrayList<>();
    private List<IShip> shipsToRemove = new ArrayList<>();
    private Player player;
    private StagePhase phase = StagePhase.INTRO;

    public StageScene() {
        player = new Player();
        this.shipsToAdd.addAll(Arrays.asList(
                player,
                ShipFactory.makeEnemy1(GAME_LEFT, GAME_TOP),
                ShipFactory.makeEnemy1(GAME_RIGHT, GAME_TOP + 60)
        ));
    }

    @Override
    public void tick(Game game) {
        switch (this.phase) {
            case INTRO:
                if (this.phaseCounter++ == INTRO_DURATION) {
                    this.phaseCounter = 0;
                    this.phase = IN_GAME;
                }
                break;
            case IN_GAME:
                doTick(game);
                if (ships.stream().filter(s -> s.getType() == ENEMY).count() == 0)
                    this.phase = ENDING;
                break;
            case ENDING:
                if (this.phaseCounter++ == ENDING_DURATION) {
                    game.setScene(this.nextScene());
                }
                break;
            case GAME_OVER:
                game.setScene(new GameOverScene());
                break;
        }
    }

    public void draw(IDrawer drawer) {
        switch (this.phase) {
            case INTRO:
                drawer.background(0, 0, 0);
                drawer.fill(255, 255, 255);
                drawer.textAlign(IDrawer.TEXT_CENTER, IDrawer.TEXT_CENTER);
                drawer.textFont("future.ttf", 20);
                drawer.text("Stage 1", GAME_CENTER_X, GAME_CENTER_Y);
                break;
            case IN_GAME:
            case ENDING:
                drawer.background("bg.jpg");
                ships.forEach(o -> o.draw(drawer));
                break;
        }
    }

    private IScene nextScene() {
        return new GameOverScene();
    }

    private void doTick(Game game) {
        shipsToRemove.forEach(s -> {
            s.detach(this);
            ships.remove(s);
        });
        shipsToRemove.clear();

        shipsToAdd.forEach(s -> {
            s.attach(this);
            ships.add(s);
        });
        shipsToAdd.clear();

        this.collisionCheck(game);

        ships.forEach(IShip::tick);
    }

    private void collisionCheck(Game game) {
        for (int i = 0; i < ships.size(); i++) {
            IShip s1 = ships.get(i);

            for (int j = i + 1; j < ships.size(); j++) {
                IShip s2 = ships.get(j);

                if (!s1.canCollideWith(s2) || !s2.canCollideWith(s1))
                    continue;

                if (s1 instanceof Ship && s2 instanceof Ship) {
                    // bounding boxes collision check
                    if (s1.getLeft() > s2.getRight() || s1.getRight() < s2.getLeft() || s1.getTop() > s1.getBottom() || s1.getBottom() < s2.getTop()) {
                        continue;
                    }

                    // pixel perfect test
                    int topMax = s1.getTop() > s2.getTop() ? s1.getTop() : s2.getTop();
                    int bottomMin = s1.getBottom() < s2.getBottom() ? s1.getBottom() : s2.getBottom();
                    int leftMax = s1.getLeft() > s2.getLeft() ? s1.getLeft() : s2.getLeft();
                    int rightMin = s1.getRight() < s2.getRight() ? s1.getRight() : s2.getRight();
                    int[] contour1 = game.getAssetsManager().getContour(s1.getView().getImgSrc());
                    int[] contour2 = game.getAssetsManager().getContour(s2.getView().getImgSrc());

                    for (int locY = topMax; locY <= bottomMin; locY++) {
                        for (int locX = leftMax; locX <= rightMin; locX++) {
                            // collision detected
                            if (contour1[(locY - s1.getTop()) * s1.getWidth() + (locX - s1.getLeft())] > 0 && contour2[(locY - s2.getTop()) * s2.getWidth() + (locX - s2.getLeft())] > 0) {
                                s1.collidedWith(s2);
                                s2.collidedWith(s1);
                            }
                        }
                    }
                }
            }
        }
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
            case SPACE:
                player.shoot();
                break;
        }
    }

    @Override
    public void update(GameEvent event) {
        if (event instanceof EventShipCreated) {
            this.shipsToAdd.add(((EventShipCreated) event).getCreatedShip());
        } else if (event instanceof EventShipDestroyed) {
            IShip destroyedShip = ((EventShipDestroyed) event).getDestroyedShip();

            if (destroyedShip == player)
                this.phase = GAME_OVER;

            this.shipsToRemove.add(destroyedShip);
        }
    }
}
