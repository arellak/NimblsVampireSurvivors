package de.nimbl.vampiresurvivors.items.weapons;

import de.nimbl.vampiresurvivors.items.weapons.displays.WeaponDisplay;
import de.nimbl.vampiresurvivors.items.weapons.entities.WeaponEntity;

public class Weapon {

    protected WeaponDisplay display;
    protected WeaponEntity entity;

    public Weapon() {

    }

    public void setDisplay(WeaponDisplay display) {
        this.display = display;
    }

    public WeaponDisplay getDisplay() {
        return this.display;
    }

    public void setEntity(WeaponEntity entity) {
        this.entity = entity;
    }

    public WeaponEntity getEntity() {
        return this.entity;
    }

}
