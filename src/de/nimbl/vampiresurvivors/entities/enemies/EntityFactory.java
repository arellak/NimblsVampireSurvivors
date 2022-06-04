package de.nimbl.vampiresurvivors.entities.enemies;

import de.nimbl.vampiresurvivors.entities.Entity;
import de.nimbl.vampiresurvivors.entities.Player;
import de.nimbl.vampiresurvivors.items.weapons.Weapon;
import de.nimbl.vampiresurvivors.items.weapons.displays.GarlicDisplay;
import de.nimbl.vampiresurvivors.items.weapons.entities.GarlicWeapon;
import de.nimbl.vampiresurvivors.items.weapons.displays.WeaponDisplay;
import de.nimbl.vampiresurvivors.maths.Vec2;

public class EntityFactory {

    public static Config entityConfig = new Config("entities");

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

    public static Weapon createWeapon(EntityType type) {
        Weapon weapon = new Weapon();

        String label = entityConfig.properties.getProperty(type.toString() + "_LABEL");
        float baseDamage = Float.parseFloat(entityConfig.properties.getProperty(type.toString() + "_BASE_DAMAGE"));
        int maxLevel = Integer.parseInt(entityConfig.properties.getProperty(type.toString() + "_MAX_LEVEL"));
        float damageMultiplier = Float.parseFloat(entityConfig.properties.getProperty(type.toString() + "_DAMAGE_MULTIPLIER"));
        float startCooldown = Float.parseFloat(entityConfig.properties.getProperty(type.toString() + "_START_COOLDOWN"));

        switch(type) {
            // case ITEM_PENIS -> weapon = new PenisWeapon(new Vec2(0, 0));
            case GARLIC -> {
                weapon.setDisplay(new GarlicDisplay());
                weapon.setEntity(new GarlicWeapon(new Vec2(0, 0)));
            }
        }

        if(weapon.getDisplay() != null) {
            weapon.getDisplay().setLabel(label);
        }

        if(weapon.getEntity() != null) {
            weapon.getEntity().setBaseDamage(baseDamage);
            weapon.getEntity().setMaxLevel(maxLevel);
            weapon.getEntity().setDamageMultiplier(damageMultiplier);
            weapon.getEntity().setCooldown(startCooldown);
        }

        return weapon;
    }

}