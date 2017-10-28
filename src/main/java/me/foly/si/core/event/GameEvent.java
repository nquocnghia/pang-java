package me.foly.si.core.event;

public class GameEvent {
    private SiObservable observable;

    public GameEvent(SiObservable observable) {
        this.observable = observable;
    }

    public SiObservable getObservable() {
        return observable;
    }

    public void setObservable(SiObservable observable) {
        this.observable = observable;
    }
}