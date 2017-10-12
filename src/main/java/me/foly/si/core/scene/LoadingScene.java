package me.foly.si.core.scene;

import me.foly.si.core.Game;
import me.foly.si.core.IAssetsManager;
import me.foly.si.core.IDrawer;
import me.foly.si.core.misc.InputKey;

import static me.foly.si.core.SiConstants.*;

public class LoadingScene implements IScene {
    // configurable parameters
    private final int BAR_PADDING = 10;
    private final int BAR_WIDTH = GAME_WIDTH / 2;
    private final int BAR_HEIGHT = 50;
    // computed values
    private final int BAR_X = GAME_CENTER_X - this.BAR_WIDTH / 2;
    private final int BAR_Y = GAME_CENTER_Y - this.BAR_HEIGHT / 2;
    private final int OUTER_BAR_X = this.BAR_X - this.BAR_PADDING;
    private final int OUTER_BAR_Y = this.BAR_Y - this.BAR_PADDING;
    private final int OUTER_BAR_WIDTH = this.BAR_WIDTH + this.BAR_PADDING * 2;
    private final int OUTER_BAR_HEIGHT = this.BAR_HEIGHT + this.BAR_PADDING * 2;

    private IAssetsManager assetsManager;

    public LoadingScene(IAssetsManager assetsManager) {
        this.assetsManager = assetsManager;
    }

    @Override
    public void tick(Game game) {
        if (assetsManager.isPreloadingDone()) {
            game.setScene(new MenuScene());
        }
    }

    @Override
    public void draw(IDrawer drawer) {
        double progress = this.assetsManager.getPreloadingProgress();

        drawer.fill(0, 0, 0);
        drawer.rect(0, 0, CANVAS_WIDTH, CANVAS_HEIGHT);

        drawer.nofill();
        drawer.stroke(255, 255, 255);
        drawer.rect(this.OUTER_BAR_X, this.OUTER_BAR_Y, this.OUTER_BAR_WIDTH, this.OUTER_BAR_HEIGHT);

        drawer.noStroke();
        drawer.fill(255, 0, 0);
        drawer.rect(this.BAR_X, this.BAR_Y, (int) (this.BAR_WIDTH * progress), this.BAR_HEIGHT);

        drawer.fill(255, 255, 255);
        drawer.textAlign(IDrawer.TEXT_CENTER, IDrawer.TEXT_CENTER);
        drawer.textSize(20);
        drawer.text(String.format("%d%%", (int) (progress * 100)), GAME_CENTER_X, GAME_CENTER_Y);

    }

    @Override
    public void keyReleased(InputKey key, Game game) {

    }

    @Override
    public void keyPressed(InputKey key, Game game) {

    }
}
