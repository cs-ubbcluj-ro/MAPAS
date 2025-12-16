package lecture.livecoding;


import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

// Exemplu de implementare Singleton, corect cat timp programul
// ruleaza pe un singur fir de executie
// FIXME De reparat pentru multi-thread
public class Settings {
    /*
    Reprezentarea ca obiect a fisierului settings.properties
     */
    private final IRepository repository;
    private final String repoFile;

    private static Settings instance;

    private Settings(IRepository repoType, String repoFile) {
        this.repository = repoType;
        this.repoFile = repoFile;
    }

    public IRepository getRepository() {
        return repository;
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

                String repoClassName = properties.getProperty("repo_class");
                String repoFile = properties.getProperty("repo_file");

                Class repoClass = Class.forName(repoClassName);
                IRepository repoObject = null;

                if (repoFile == null) {
                    // repository-ul are un constructor fara parametri
                    Constructor repoClassConstructor = repoClass.getConstructor();
                    repoObject = (IRepository) repoClassConstructor.newInstance();
                } else {
                    // repository-ul are un constructor cu un String ca parametru
                    Constructor repoClassConstructor = repoClass.getConstructor(String.class);
                    repoObject = (IRepository) repoClassConstructor.newInstance(repoFile);
                }

                instance = new Settings(repoObject, repoFile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } finally {
//                fr.close();
            }

        }
        return instance;
    }
}
