package de.nimbl.vampiresurvivors.entities.enemies;

import de.nimbl.vampiresurvivors.entities.Entity;
import de.nimbl.vampiresurvivors.entities.Player;
import de.nimbl.vampiresurvivors.items.PenisWeapon;
import de.nimbl.vampiresurvivors.items.WeaponType;
import de.nimbl.vampiresurvivors.items.Weapon;
import de.nimbl.vampiresurvivors.maths.Vec2;

public class EntityFactory {

    public static Config entityConfig = new Config("entities");
    public static Config weaponConfig = new Config("weapons");

    public static Entity createEntity(EntityType type, Vec2 startPos){
        float baseSpeed = Float.parseFloat(entityConfig.properties.getProperty(type.toString() + "_BASE_SPEED"));
        float health = Float.parseFloat(entityConfig.properties.getProperty(type.toString() + "_HEALTH"));
        float damage = Float.parseFloat(entityConfig.properties.getProperty(type.toString() + "_DAMAGE"));

        Entity ent;

        switch(type) {
            case BAT -> ent = new Bat(startPos);
            case PLAYER -> ent = new Player(startPos);
            default -> ent = new Entity(startPos);
        }

        ent.setMaxSpeed(baseSpeed);
        ent.setHealth(health);
        ent.setDamage(damage);

        return ent;
    }

    public static Weapon createWeapon(WeaponType type) {
        Weapon weapon;

        float baseDamage = Float.parseFloat(weaponConfig.properties.getProperty(type.toString() + "_BASE_DAMAGE"));
        String label = weaponConfig.properties.getProperty(type.toString() + "_LABEL");

        switch(type) {
            case PENIS -> weapon = new PenisWeapon();
            default -> weapon = new Weapon();
        }

        weapon.setBaseDamage(baseDamage);
        weapon.setLabel(label);

        return weapon;
    }

}