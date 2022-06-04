package de.nimbl.vampiresurvivors.game;

import com.raylib.java.Raylib;
import com.raylib.java.core.Color;
import de.nimbl.vampiresurvivors.entities.Player;
import de.nimbl.vampiresurvivors.entities.enemies.EnemyManager;
import de.nimbl.vampiresurvivors.entities.enemies.EntityFactory;
import de.nimbl.vampiresurvivors.entities.enemies.EntityType;
import de.nimbl.vampiresurvivors.items.weapons.WeaponRunnable;
import de.nimbl.vampiresurvivors.items.weapons.WeaponType;
import de.nimbl.vampiresurvivors.maths.Vec2;
import de.nimbl.vampiresurvivors.utils.GameFiles;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

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
        player.addWeapon(EntityFactory.createWeapon(EntityType.GARLIC));

        enemyManager.createEnemy(EntityType.BAT);
    }

    public void gameLoop() {
        long countdown = 500;
        ScheduledExecutorService weaponScheduler = Executors.newScheduledThreadPool(1);
        weaponScheduler.scheduleAtFixedRate(new WeaponRunnable(countdown, player), countdown, countdown, TimeUnit.MILLISECONDS);

        while (!ray.core.WindowShouldClose()) {
            ray.core.BeginDrawing();
            ray.core.ClearBackground(Color.DARKGRAY);

            enemyManager.checkForCollisionToDoDamage(player);

            enemyManager.update(player.getPos());
            player.update();

            enemyManager.render();
            player.render();

            player.execute();

            ray.core.EndDrawing();
        }

        weaponScheduler.shutdownNow();
        ray.core.CloseWindow();
    }

}
