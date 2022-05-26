package de.nimbl.vampiresurvivors.entities;

import com.raylib.java.core.Color;
import com.raylib.java.core.input.Keyboard;
import com.raylib.java.shapes.Rectangle;
import com.raylib.java.textures.Texture2D;
import de.nimbl.vampiresurvivors.IRenderable;
import de.nimbl.vampiresurvivors.entities.enemies.EntityType;
import de.nimbl.vampiresurvivors.game.Game;
import de.nimbl.vampiresurvivors.maths.Vec2;

import com.raylib.java.core.rCore;
import de.nimbl.vampiresurvivors.utils.GameFiles;

public class Entity implements IRenderable {

    protected float health;
    protected float damage;
    protected boolean dead;

    protected float maxSpeed;

    protected /* final*/ EntityType entityType;

    protected Vec2 pos;

    protected int modelId;
    protected Color tint;

    public Entity(Vec2 startPos) {
        setPos(startPos);
    }

    @Override
    public void update() {
    }

    @Override
    public void render() {
        if(tint == null) {
            tint = Color.BLACK;
        }

        if(getHealth() <= 0) {
            return;
        }

        GameFiles.drawTexture(GameFiles.getEntityTexture(getModelId()), (int) getPos().getX(), (int) getPos().getY(), tint);
    }

    public void follow(Vec2 position) {
        Vec2 way = new Vec2(position);
        way.sub(getPos());
        way.setMagnitude(maxSpeed);

        Vec2 push = new Vec2(way.getX(), way.getY(), maxSpeed);
        getPos().add(push);
    }

    public void move() {
        if(rCore.IsKeyDown(Keyboard.KEY_D)) {
            follow(new Vec2(getPos().getX()+maxSpeed*5, getPos().getY()));
        }
        if(rCore.IsKeyDown(Keyboard.KEY_A)) {
            follow(new Vec2(getPos().getX()-maxSpeed*5, getPos().getY()));
        }
        if(rCore.IsKeyDown(Keyboard.KEY_W)) {
            follow(new Vec2(getPos().getX(), getPos().getY()-maxSpeed*5));
        }
        if(rCore.IsKeyDown(Keyboard.KEY_S)) {
            follow(new Vec2(getPos().getX(), getPos().getY()+maxSpeed*5));
        }
    }

    public boolean collides(Entity toCompare) {
        Texture2D entityModel = GameFiles.getEntityTexture(getModelId());
        Texture2D toCompareModel = GameFiles.getEntityTexture(toCompare.getModelId());

        boolean collideX = toCompare.getPos().getX() < getPos().getX() + entityModel.getWidth()
                && toCompare.getPos().getX() + toCompareModel.getWidth() > getPos().getX();

        boolean collideY = toCompare.getPos().getY() < getPos().getY() + entityModel.getHeight()
                && toCompare.getPos().getY() + toCompareModel.getHeight() > getPos().getY();

        return collideX && collideY;
    }

    public void setMaxSpeed(float maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public float getMaxSpeed() {
        return this.maxSpeed;
    }

    public float getHealth() {
        return health;
    }

    public void setHealth(float health) {
        this.health = health;
    }

    public void updateHealth(float newHealth) {
        this.health += newHealth;
    }

    public float getDamage() {
        return damage;
    }

    public void setDamage(float damage) {
        this.damage = damage;
    }

    public void addDamage(float newDamage) {
        this.damage += newDamage;
    }

    public void multiplyDamage(float newDamage) {
        this.damage *= newDamage;
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public Vec2 getPos() {
        return pos;
    }

    public void setPos(Vec2 pos) {
        this.pos = pos;
    }

    public void setModelId(int modelId) {
        this.modelId = modelId;
    }

    public int getModelId() {
        return modelId;
    }

    public void setEntityType(EntityType entityType) {
        this.entityType = entityType;
    }

    public EntityType getEntityType() {
        return this.entityType;
    }

    public void setTint(Color tint) {
        this.tint = tint;
    }

    public Color getTint() {
        return this.tint;
    }
}