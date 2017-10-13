package me.foly.si.core.scene;

import me.foly.si.core.Game;
import me.foly.si.core.IDrawer;
import me.foly.si.core.misc.InputKey;

public interface IScene {
    void tick(Game game);

    void draw(IDrawer drawer);

    void keyReleased(InputKey key, Game game);

    void keyPressed(InputKey key, Game game);
}
