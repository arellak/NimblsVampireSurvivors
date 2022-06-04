package de.nimbl.vampiresurvivors.items.weapons;

import de.nimbl.vampiresurvivors.entities.Player;
import de.nimbl.vampiresurvivors.items.weapons.displays.WeaponDisplay;
import de.nimbl.vampiresurvivors.items.weapons.entities.WeaponEntity;

public class WeaponRunnable implements Runnable {

    private Player player;
    private long countdown;

    public WeaponRunnable(long countdown, Player player) {
        this.player = player;
        this.countdown = countdown;
    }

    @Override
    public void run() {
        for(Weapon weapon : player.getWeapons()) {
            weapon.getEntity().reduceCooldown(millisToSeconds(countdown));
        }
    }

    private float millisToSeconds(long millis) {
        return (float) millis / 1000;
    }

}