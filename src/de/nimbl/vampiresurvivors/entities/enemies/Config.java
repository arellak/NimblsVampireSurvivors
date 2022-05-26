package de.nimbl.vampiresurvivors.entities.enemies;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

    public Properties properties;
    private String configName;

    public Config(String configName) {
        properties = new Properties();
        this.configName = configName;
        read();
    }

    public void read() {
        InputStream stream = null;
        try {
            stream = this.getClass().getClassLoader().getResourceAsStream("config/" + configName + ".properties");
            if (stream == null) throw new IOException("File not found");
            properties.load(stream);
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            if(stream != null) {
                try {
                    stream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String getConfigName() {
        return this.configName;
    }

}