package me.foly.si.game;

import me.foly.si.domain.general.GObject;

import java.util.ArrayList;
import java.util.List;

public class GameModel {
    private List<GObject> objects = new ArrayList<>();

    public boolean addObject(GObject object) {
        return objects.add(object);
    }

    public boolean removeObject(GObject object) {
        return objects.remove(object);
    }

    public List<GObject> getObjects() {
        return objects;
    }
}
