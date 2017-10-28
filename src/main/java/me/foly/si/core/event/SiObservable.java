package me.foly.si.core.event;

import java.util.ArrayList;
import java.util.List;

public class SiObservable implements ISiObservable {
    private List<ISiObserver> observers = new ArrayList<>();

    @Override
    public void attach(ISiObserver o) {
        observers.add(o);
    }

    @Override
    public void detach(ISiObserver o) {
        observers.remove(o);
    }

    @Override
    public void notify(GameEvent event) {
        observers.forEach(o -> o.update(event));
    }
}
