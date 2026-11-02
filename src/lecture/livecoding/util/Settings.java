package lecture.livecoding.util;

import lecture.livecoding.domain.Shape;
import lecture.livecoding.repository.BinaryFileRepository;
import lecture.livecoding.repository.IRepository;
import lecture.livecoding.repository.MemoryRepository;
import lecture.livecoding.repository.TextFileRepository;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Settings {

    private static final String SETTINGS_FILE = "settings.properties";

    private static Settings instance;

    private IRepository<Shape> repository;

    private Settings() {

        Properties settings = new Properties();
        try {
            settings.load(new FileReader(SETTINGS_FILE));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if ("memory".equals(settings.getProperty("repository_type"))) {
            repository = new MemoryRepository<>();
            return;
        }

        if ("binary".equals(settings.getProperty("repository_type"))) {
            var fileName = settings.getProperty("repository_file");
            repository = new BinaryFileRepository<>(fileName);
            return;
        }

        if ("text".equals(settings.getProperty("repository_type"))) {
            var fileName = settings.getProperty("repository_file");
            repository = new TextFileRepository<>(fileName, new ShapeConverter<Shape>() {
                @Override
                public Shape stringToObject(String source) {
                    return null;
                }

                @Override
                public String objectToString(Shape object) {
                    return "";
                }
            });
            return;
        }
    }

    public IRepository<Shape> getRepository() {
        return repository;
    }

    public static Settings getInstance() {
        if (Settings.instance == null) {
            instance = new Settings();
        }
        return instance;
    }
}
