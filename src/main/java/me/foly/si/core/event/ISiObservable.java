package me.foly.si.core.event;

public interface ISiObservable {
    void attach(ISiObserver o);

    void detach(ISiObserver o);

    void notify(GameEvent event);
}
