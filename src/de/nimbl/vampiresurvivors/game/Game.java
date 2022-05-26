package de.nimbl.vampiresurvivors.game;

import com.raylib.java.Raylib;
import com.raylib.java.core.Color;
import de.nimbl.vampiresurvivors.entities.Player;
import de.nimbl.vampiresurvivors.entities.enemies.EnemyManager;
import de.nimbl.vampiresurvivors.entities.enemies.EntityFactory;
import de.nimbl.vampiresurvivors.entities.enemies.EntityType;
import de.nimbl.vampiresurvivors.items.WeaponType;
import de.nimbl.vampiresurvivors.maths.Vec2;
import de.nimbl.vampiresurvivors.utils.GameFiles;

public class Game {

    public static Raylib ray;

    private EnemyManager enemyManager;
    private Player player;

    public void start() {
        init();
    }

    public void init() {
        ray = new Raylib(1280, 720, "Vampire Survivors - by nimbl");
        GameFiles.load();

        enemyManager = new EnemyManager();

        player = (Player) EntityFactory.createEntity(EntityType.PLAYER, new Vec2(400, 300));
        player.addWeapon(EntityFactory.createWeapon(WeaponType.PENIS));

        enemyManager.createEnemy(EntityType.BAT);
    }

    public void gameLoop() {
        while (!ray.core.WindowShouldClose()) {
            ray.core.BeginDrawing();
            ray.core.ClearBackground(Color.DARKGRAY);

            enemyManager.checkForCollisionToDoDamage(player);
            enemyManager.update(player.getPos());
            enemyManager.render();

            player.update();
            player.render();

            ray.core.EndDrawing();
        }

        ray.core.CloseWindow();
    }

}
