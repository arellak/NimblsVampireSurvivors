package de.nimbl.vampiresurvivors.items.weapons.entities;

import de.nimbl.vampiresurvivors.entities.Entity;
import de.nimbl.vampiresurvivors.entities.enemies.EnemyManager;
import de.nimbl.vampiresurvivors.entities.enemies.EntityType;
import de.nimbl.vampiresurvivors.maths.Vec2;

import java.util.List;

public class GarlicWeapon extends WeaponEntity {

    public GarlicWeapon(Vec2 startPos) {
        super(startPos);
        setEntityType(EntityType.GARLIC);
        setModelId(4);
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void update() {
        super.update();
    }

    @Override
    public void execute() {
        super.execute();
        for(Entity enemy : EnemyManager.enemies) {
            if(collides(enemy)) {
                enemy.updateHealth(-(getBaseDamage() * getDamageMultiplier()));
            }
        }
    }

}
