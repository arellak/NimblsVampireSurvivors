package de.nimbl.vampiresurvivors.items;

import com.raylib.java.core.Color;
import de.nimbl.vampiresurvivors.IRenderable;
import de.nimbl.vampiresurvivors.entities.Entity;
import de.nimbl.vampiresurvivors.entities.enemies.EntityType;
import de.nimbl.vampiresurvivors.maths.Vec2;

public abstract class Item {

    protected String label;
    protected int modelId;
    protected Color tint;

    public Item() {

    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }

    public void setModelId(int modelId) {
        this.modelId = modelId;
    }

    public int getModelId() {
        return modelId;
    }

    public void setTint(Color tint) {
        this.tint = tint;
    }

    public Color getTint() {
        return this.tint;
    }

}