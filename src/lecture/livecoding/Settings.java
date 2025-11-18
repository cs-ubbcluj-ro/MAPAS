package lecture.livecoding;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

// Exemplu de implementare Singleton, corect cat timp programul
// ruleaza pe un singur fir de executie
// FIXME De reparat pentru multi-thread
public class Settings {
    /*
    Reprezentarea ca obiect a fisierului settings.properties
     */
    private final String repoType;
    private final String repoFile;

    private static Settings instance;

    private Settings(String repoType, String repoFile) {
        this.repoType = repoType;
        this.repoFile = repoFile;
    }

    public String getRepoType() {
        return repoType;
    }

    public String getRepoFile() {
        return repoFile;
    }

    public static Settings getInstance() {
        if (instance == null) {
            /*
            Suntem la primul apel al metodei getInstance()
            Exemplu de lazy-loading (initializam lucruri doar cand
            avem nevoie de ele)
             */
            try (var fr = new FileReader("settings.properties")) {
                var properties = new Properties();
                properties.load(fr);

                String repoType = properties.getProperty("repo_type");
                String repoFile = properties.getProperty("repo_file");

                instance = new Settings(repoType, repoFile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
//                fr.close();
            }

        }
        return instance;
    }
}
