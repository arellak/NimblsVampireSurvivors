package de.nimbl.vampiresurvivors;

import com.raylib.java.Raylib;
import com.raylib.java.core.Color;

public class VampireSurvivors {

    public static void main(String[] args) {
        Raylib ray = new Raylib();
        ray.core.InitWindow(800, 600, "Test");

        while(!ray.core.WindowShouldClose()) {
            ray.core.BeginDrawing();
            ray.core.ClearBackground(Color.DARKGRAY);
            ray.core.EndDrawing();
        }

        ray.core.CloseWindow();
    }

}