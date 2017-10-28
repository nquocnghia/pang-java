package me.foly.si.core.event;

import me.foly.si.core.ship.IShip;

public class EventShipCreated extends GameEvent {
    private IShip createdShip;

    public EventShipCreated(SiObservable observable, IShip createdShip) {
        super(observable);
        this.createdShip = createdShip;
    }

    public IShip getCreatedShip() {
        return createdShip;
    }
}
