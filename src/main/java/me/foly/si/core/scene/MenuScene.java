package me.foly.si.core.scene;

import me.foly.si.core.Game;
import me.foly.si.core.IDrawer;
import me.foly.si.core.misc.InputKey;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static me.foly.si.core.SiConstants.*;

public class MenuScene implements IScene {
    private final List<String> MENU_ITEMS = Arrays.asList("New Game", "Quit");

    private final int TITLE_Y = 130;
    private final int BTN_WIDTH = 240;
    private final int BTN_HEIGHT = 39;
    private final int BTN_X = GAME_CENTER_X - BTN_WIDTH / 2;
    private final int BTN_START_Y = 260;
    private final int BTN_MARGIN_BOTTOM = 30;
    private final int BTN_PADDING_LEFT = 10;
    private final int CURSOR_WIDTH = 30;
    private final int CURSOR_HEIGHT = 33;

    private List<MenuItem> menuItems = new ArrayList<>();
    private int currentItem = 0;

    public MenuScene() {
        // init menu items
        for (int idx = 0; idx < MENU_ITEMS.size(); idx++) {
            // button text
            String txt = MENU_ITEMS.get(idx);
            // y coordinate of the button
            int btnY = BTN_START_Y + (BTN_HEIGHT + BTN_MARGIN_BOTTOM) * idx;
            // push new item
            this.menuItems.add(new MenuItem(
                    txt,
                    BTN_X,
                    btnY,
                    BTN_X + BTN_WIDTH / 2,
                    btnY + BTN_HEIGHT / 2,
                    BTN_X + BTN_PADDING_LEFT,
                    btnY + BTN_HEIGHT / 2 - CURSOR_HEIGHT / 2));
        }
    }

    @Override
    public void tick(Game game) {

    }

    @Override
    public void draw(IDrawer drawer) {
        // background image
        drawer.image("bg.jpg", 0, 0, CANVAS_WIDTH, CANVAS_HEIGHT);

        // title
        drawer.textAlign(IDrawer.TEXT_CENTER, IDrawer.TEXT_CENTER);
        drawer.fill(85, 85, 85);
        drawer.textFont("future.ttf", 150);
        drawer.text("[ PANG ]", GAME_CENTER_X, TITLE_Y);
        drawer.noStroke();
        drawer.fill(255, 255, 255);
        drawer.textFont("future.ttf", 110);
        drawer.text("[ PANG ]", GAME_CENTER_X, TITLE_Y);

        // menu items
        for (int idx = 0; idx < menuItems.size(); idx++) {
            // button text
            MenuItem item = menuItems.get(idx);

            // button image
            drawer.image("buttonRed.png", item.btnX, item.btnY, BTN_WIDTH, BTN_HEIGHT);

            // if current item is selected
            if (idx == this.currentItem) {
                drawer.image("cursor.png", item.cursorX, item.cursorY, CURSOR_WIDTH, CURSOR_HEIGHT);
                drawer.fill(51, 51, 51);
            } else {
                drawer.fill(170, 170, 170);
            }

            // text
            drawer.textAlign(IDrawer.TEXT_CENTER, IDrawer.TEXT_CENTER);
            drawer.textFont("future.ttf", 20);
            drawer.text(item.text, item.btnCenterX, item.btnCenterY);
        }

        // credit
        drawer.textAlign(IDrawer.TEXT_CENTER, IDrawer.TEXT_BOTTOM);
        drawer.textFont("future.ttf", 15);
        drawer.fill(255, 255, 255);
        drawer.text("Developed by foly", GAME_CENTER_X, GAME_BOTTOM);
    }

    @Override
    public void keyReleased(InputKey key, Game game) {

    }

    @Override
    public void keyPressed(InputKey key, Game game) {
        switch (key) {
            case UP:
                this.currentItem -= this.currentItem == 0 ? 0 : 1;
                break;
            case DOWN:
                this.currentItem += this.currentItem == this.menuItems.size() - 1 ? 0 : 1;
                break;
            case SPACE:
                switch (this.currentItem) {
                    case 0: //new game
                        game.setScene(new StageScene());
                        break;
                    case 1:
                        System.exit(0);
                        break;
                }
                break;
        }
    }

    private class MenuItem {
        private final String text;
        private final int btnX;
        private final int btnY;
        private final int btnCenterX;
        private final int btnCenterY;
        private final int cursorX;
        private final int cursorY;

        private MenuItem(String text, int btnX, int btnY, int btnCenterX, int btnCenterY, int cursorX, int cursorY) {
            this.text = text;
            this.btnX = btnX;
            this.btnY = btnY;
            this.btnCenterX = btnCenterX;
            this.btnCenterY = btnCenterY;
            this.cursorX = cursorX;
            this.cursorY = cursorY;
        }
    }
}
