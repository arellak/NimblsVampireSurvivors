package de.nimbl.vampiresurvivors.items.weapons.entities;

import com.raylib.java.core.Color;
import de.nimbl.vampiresurvivors.entities.Entity;
import de.nimbl.vampiresurvivors.maths.Vec2;
import de.nimbl.vampiresurvivors.utils.GameFiles;

public class WeaponEntity extends Entity {

    protected float baseDamage;
    protected float damageMultiplier;

    protected int level;
    protected int maxLevel;

    protected float cooldown;
    protected float currentCooldown;

    protected String label;

    public WeaponEntity(Vec2 startPos) {
        super(startPos);
        this.level = 1;
        this.baseDamage = 1;
        this.tint = Color.BLACK;
    }

    @Override
    public void update() {
        super.update();
    }

    @Override
    public void render() {
        GameFiles.drawTexture(GameFiles.getEntityTexture(getModelId()), (int) getPos().getX(), (int) getPos().getY(), tint);
    }

    public void execute() {
    }

    public void setBaseDamage(float baseDamage) {
        this.baseDamage = baseDamage;
    }

    public float getBaseDamage() {
        return this.baseDamage;
    }

    public void setCooldown(float cooldown) {
        this.cooldown = cooldown;
        this.currentCooldown = cooldown;
    }

    public float getCooldown() {
        return this.cooldown;
    }

    public void reduceCooldown(float toReduce) {
        this.currentCooldown -= toReduce;
    }

    public void resetCooldown() {
        this.currentCooldown = this.cooldown;
    }

    public float getCurrentCooldown() {
        return this.currentCooldown;
    }

    public void setDamageMultiplier(float damageMultiplier) {
        this.damageMultiplier = damageMultiplier;
    }

    public float getDamageMultiplier() {
        return this.damageMultiplier;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return this.level;
    }

    public void setMaxLevel(int maxLevel) {
        this.maxLevel = maxLevel;
    }

    public int getMaxLevel() {
        return this.maxLevel;
    }

}
