package de.nimbl.vampiresurvivors.items;

public class Weapon extends Item {

    protected float baseDamage;
    protected WeaponType type;

    public Weapon() {
        this.baseDamage = 1;
    }

    public void setBaseDamage(float baseDamage) {
        this.baseDamage = baseDamage;
    }

    public float getBaseDamage() {
        return this.baseDamage;
    }

    public void setType(WeaponType type) {
        this.type = type;
    }

    public WeaponType getType() {
        return this.type;
    }

}