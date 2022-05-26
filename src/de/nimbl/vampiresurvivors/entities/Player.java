package de.nimbl.vampiresurvivors.entities;

import de.nimbl.vampiresurvivors.entities.enemies.EntityType;
import de.nimbl.vampiresurvivors.items.Weapon;
import de.nimbl.vampiresurvivors.maths.Vec2;

import java.util.ArrayList;
import java.util.List;

public class Player extends Entity {

    private List<Weapon> weapons;

    public Player(Vec2 startPos) {
        super(startPos);
        weapons = new ArrayList<>();

        setEntityType(EntityType.PLAYER);
        setModelId(1);
        setDead(false);
    }

    @Override
    public void update() {
        if(getHealth() <= 0) {
            setDead(true);
            return;
            // pause game? game over screen?
        }
        move();
    }

    @Override
    public void render() {
        if(isDead()) {
            return;
        }
        super.render();
    }

    public void addWeapon(Weapon weapon) {
        weapons.add(weapon);
    }

    @Override
    public float getDamage() {
        float damage = super.getDamage();

        for(Weapon weapon : weapons) {
            damage += weapon.getBaseDamage();
        }

        return damage;
    }
}