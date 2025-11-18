package lecture.livecoding;

public class Lecture7 {
    /*
     https://refactoring.guru/design-patterns

     Singleton
     https://refactoring.guru/design-patterns/singleton

    Iterator
    https://refactoring.guru/design-patterns/iterator


     */
    public static void main(String[] args) {

        Settings settings = Settings.getInstance();

        System.out.println(Settings.getInstance() == Settings.getInstance());

        System.out.println(settings.getRepoType());
        System.out.println(settings.getRepoFile());

//        IRepository repo;

        if ("sql".equals(settings.getRepoType())) {

            try (var repo = new SQLSquareRepository()) {

                for (var s : repo) {
                    System.out.println(s);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }
    }
}
