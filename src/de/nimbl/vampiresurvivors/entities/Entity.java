package de.nimbl.vampiresurvivors.entities;

public abstract class Entity {

    private int health;
    private int damage;
    private boolean dead;

    public abstract void update();
    public abstract void render();

}
