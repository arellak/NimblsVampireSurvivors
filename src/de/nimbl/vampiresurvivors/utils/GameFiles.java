package de.nimbl.vampiresurvivors.utils;

import com.raylib.java.core.Color;
import com.raylib.java.textures.Texture2D;
import de.nimbl.vampiresurvivors.VampireSurvivors;
import de.nimbl.vampiresurvivors.game.Game;

import java.util.HashMap;

public class GameFiles {

    private static HashMap<Integer, Texture2D> items = new HashMap<Integer, Texture2D>();
    private static HashMap<Integer, Texture2D> entities = new HashMap<Integer, Texture2D>();

    public static void load() {
        loadItemTextures();
        loadEntityTextures();
        loadMapTextures();
    }

    public static void loadItemTextures() {
    }

    public static void loadEntityTextures() {
        entities.put(0, new Texture2D("res/textures/entities/player_damaged.png"));
        entities.put(1, new Texture2D("res/textures/entities/player.png"));
        entities.put(2, new Texture2D("res/textures/entities/bat.png"));

        entities.put(3, new Texture2D("res/textures/items/penis.png"));


        Texture2D garlicTexture = new Texture2D("res/textures/items/garlic.png");
        garlicTexture.setWidth(garlicTexture.getWidth() * 4);
        garlicTexture.setHeight(garlicTexture.getHeight() * 4);
        entities.put(4, garlicTexture);
    }

    public static void loadMapTextures() {
    }

    public static void drawTexture(Texture2D texture, int posX, int posY, Color color) {
        Game.ray.textures.DrawTexture(texture, posX, posY, color);
    }

    public static Texture2D getEntityTexture(int id) {
        return entities.get(id);
    }

    public static Texture2D getItemTexture(int id) {
        return items.get(id);
    }

}