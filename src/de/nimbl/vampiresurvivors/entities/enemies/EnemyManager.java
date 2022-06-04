package de.nimbl.vampiresurvivors.entities.enemies;

import com.raylib.java.core.Color;
import de.nimbl.vampiresurvivors.entities.Entity;
import de.nimbl.vampiresurvivors.entities.Player;
import de.nimbl.vampiresurvivors.maths.Vec2;

import java.util.ArrayList;
import java.util.List;

public class EnemyManager {

    public static final List<Entity> enemies = new ArrayList<>();

    public void createEnemy(EntityType enemyType) {
        enemies.add(EntityFactory.createEntity(enemyType, new Vec2(0, 0)));
    }

    public void update(Vec2 playerPos) {
        for(Entity enemy : enemies) {
            enemy.follow(playerPos);
            enemy.update();
        }
    }

    public void render() {
        for(Entity enemy : enemies) {
            enemy.render();
        }
    }

    public void deleteEnemy() {
        List<Entity> toRemove = new ArrayList<>();
        for(Entity enemy : enemies) {
            if(enemy.getHealth() <= 0) {
                toRemove.add(enemy);
            }
        }
        enemies.removeAll(toRemove);
    }

    public void checkForCollisionToDoDamage(Player player) {
        int count = enemies.size();
        for(Entity enemy : enemies) {
            if(player.collides(enemy)) {
                player.setModelId(0);
                player.setTint(Color.RED);

                enemy.updateHealth(-player.getDamage());
                player.updateHealth(-enemy.getDamage());
            } else {
                if(count > 0) {
                    count--;
                }
            }
        }

        if(player.getModelId() == 0 && count <= 0) {
            player.setModelId(1);
            player.setTint(Color.BLACK);
        }

    }

}