package de.nimbl.vampiresurvivors.entities;

import de.nimbl.vampiresurvivors.entities.enemies.EntityType;
import de.nimbl.vampiresurvivors.items.weapons.Weapon;
import de.nimbl.vampiresurvivors.items.weapons.displays.WeaponDisplay;
import de.nimbl.vampiresurvivors.items.weapons.entities.WeaponEntity;
import de.nimbl.vampiresurvivors.maths.Vec2;
import de.nimbl.vampiresurvivors.utils.GameFiles;

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

        for(Weapon weapon : weapons) {
            weapon.getEntity().render();
        }
    }

    public void addWeapon(Weapon weapon) {
        weapons.add(weapon);
    }

    public List<Weapon> getWeapons() {
        return this.weapons;
    }

    public static Vec2 getNearestEntity(List<Entity> enemies) {
        Vec2 nearestEntity = new Vec2(0, 0);
        for(Entity enemy : enemies) {
            if(enemy.getPos().getLength() < nearestEntity.getLength()) {
                nearestEntity = enemy.getPos();
            }
        }
        return nearestEntity;

    }

    public void execute() {
        for(Weapon weapon : weapons) {
            if(weapon.getEntity().getEntityType() == EntityType.GARLIC) {
                int weaponId = weapon.getEntity().getModelId();
                float posX = getPos().getX() - (GameFiles.getEntityTexture(weaponId).getWidth() / 2);
                float posY = getPos().getY() - (GameFiles.getEntityTexture(weaponId).getHeight() / 2);

                weapon.getEntity().setPos(new Vec2(posX, posY));
            }

            if(weapon.getEntity().getCurrentCooldown() <= 0) {
                // weapon.reset() => setPos(startPos)
                // weapon.getEntity().setPos(getPos());
                weapon.getEntity().execute();
                weapon.getEntity().resetCooldown();
            }
        }
    }

}