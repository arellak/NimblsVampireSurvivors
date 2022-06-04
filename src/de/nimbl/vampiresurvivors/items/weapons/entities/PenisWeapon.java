package de.nimbl.vampiresurvivors.items.weapons.entities;

import com.raylib.java.core.Color;
import de.nimbl.vampiresurvivors.entities.Entity;
import de.nimbl.vampiresurvivors.entities.Player;
import de.nimbl.vampiresurvivors.entities.enemies.EnemyManager;
import de.nimbl.vampiresurvivors.maths.Vec2;
import de.nimbl.vampiresurvivors.utils.GameFiles;

public class PenisWeapon extends WeaponEntity {

    public PenisWeapon(Vec2 startPos) {
        super(startPos);
        setModelId(0);
        // setEntityType(EntityType.ITEM_PENIS);
    }

    @Override
    public void update() {
        super.update();
        Vec2 nearestEntityPos = Player.getNearestEntity(EnemyManager.enemies);

        if(getCurrentCooldown() <= 0) {
            follow(nearestEntityPos);
            // this.currentCooldown = cooldown;
        }
    }

    @Override
    public void render() {
        // super.render();
        if(tint == null) {
            tint = Color.BLACK;
        }
        GameFiles.drawTexture(GameFiles.getItemTexture(0), (int) getPos().getX(), (int) getPos().getY(), tint);
    }

    public void execute() {
        super.execute();
        render();
    }

}
