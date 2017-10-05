package me.foly.si.core;

public class SiConstants {
    // window size
    public static final int PADDING = 10;
    public static final int GAME_WIDTH = 800;
    public static final int GAME_HEIGHT = 600;
    public static final int CANVAS_WIDTH = GAME_WIDTH + PADDING * 2;
    public static final int CANVAS_HEIGHT = GAME_HEIGHT + PADDING * 2;

    // for border detection
    public static final int GAME_LEFT = PADDING;
    public static final int GAME_TOP = PADDING;
    // -1 because the pixel matrix is 0-based indexed
    public static final int GAME_RIGHT = GAME_LEFT + GAME_WIDTH - 1;
    public static final int GAME_BOTTOM = GAME_TOP + GAME_HEIGHT - 1;
    public static final int GAME_CENTER_X = GAME_LEFT + GAME_WIDTH / 2 - 1;
    public static final int GAME_CENTER_Y = GAME_TOP + GAME_HEIGHT / 2 - 1;

    // frames per second
    public static final int FPS = 60;
}
