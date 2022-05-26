package de.nimbl.vampiresurvivors.entities.enemies;

import com.raylib.java.core.Color;
import de.nimbl.vampiresurvivors.entities.Entity;
import de.nimbl.vampiresurvivors.maths.Vec2;
import de.nimbl.vampiresurvivors.utils.GameFiles;

public class Bat extends Entity {

    public Bat(Vec2 startPos, float baseSpeed, float startHealth, float startDamage) {
        super(startPos);
        maxSpeed = baseSpeed;
        health = startHealth;
        damage = startDamage;
        setModelId(2);
        this.entityType = EntityType.BAT;
    }

    public Bat(Vec2 startPos) {
        super(startPos);
        setModelId(2);
        this.entityType = EntityType.BAT;
    }

    @Override
    public void update() {

    }

    @Override
    public void render() {
        super.render();
    }
}
