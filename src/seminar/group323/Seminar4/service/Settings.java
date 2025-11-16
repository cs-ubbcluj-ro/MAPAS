package seminar.group323.Seminar4.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class Settings {
    private static Settings instance;
    private final Properties properties = new Properties();

    private Settings() {
        try {
            // Try multiple possible locations for settings.properties
            Path settingsPath = Path.of("settings.properties");
            if (!Files.exists(settingsPath)) {
                settingsPath = Path.of("Seminar4/settings.properties");
            }
            if (!Files.exists(settingsPath)) {
                settingsPath = Path.of("src/seminar/group323/Seminar4/settings.properties");
            }
            
            if (Files.exists(settingsPath)) {
                try (FileInputStream fis = new FileInputStream(settingsPath.toFile())) {
                    properties.load(fis);
                }
            } else {
                // Set default values if file not found
                System.out.println("Warning: settings.properties not found. Using defaults.");
                properties.setProperty("Repository", "memory");
                properties.setProperty("Albums", "data/albums.txt");
                properties.setProperty("Music", "data/music.txt");
                properties.setProperty("DatabasePath", "data/store.db");
            }
        } catch (IOException e) {
            System.err.println("Error reading settings.properties: " + e.getMessage());
            throw new RuntimeException("Eroare la citirea fișierului de configurare!", e);
        }
    }

    public static Settings getInstance() {
        if (instance == null) {
            synchronized (Settings.class) {
                if (instance == null) {
                    instance = new Settings();
                }
            }
        }
        return instance;
    }

    public String get(String key) {
        return properties.getProperty(key);
    }
    
    public String getRepositoryType() {
        return properties.getProperty("Repository", "memory").toLowerCase();
    }
    
    public String getAlbumsPath() {
        return properties.getProperty("Albums", "data/albums.txt");
    }
    
    public String getMusicPath() {
        return properties.getProperty("Music", "data/music.txt");
    }
    
    public String getDatabasePath() {
        return properties.getProperty("DatabasePath", "data/store.db");
    }
}
