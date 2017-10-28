package me.foly.si.core.event;

import me.foly.si.core.ship.IShip;

public class EventShipDestroyed extends GameEvent {
    private IShip destroyedShip;

    public EventShipDestroyed(SiObservable observable, IShip destroyedShip) {
        super(observable);
        this.destroyedShip = destroyedShip;
    }

    public IShip getDestroyedShip() {
        return destroyedShip;
    }
}
