package seminar.group321.seminar2;

public class ConsoleUI {

    private AuthorService authorService;

    public ConsoleUI(AuthorService authorService) {
        /*
        Este important ca parametrii sa fie transmisi prin constructor => "dependency injection"
        "dependency injection" - clasa *Service, ca sa isi faca treaba au nevoie de un repository; acest repository
        le este transmis ca parametru; faptul ca instanta e primita ca parametru inseamna ca putem alege oricare
        implementare de repository conforma (tine datele in memorie, fisier, SQL, etc.)
        !! clasa Service nu ar trebui sa stie, sau sa fie interesata de cum lucreaza Repository-ul dat ca
        parametru
         */
        this.authorService = authorService;
    }

    private void printMenu() {
        System.out.println("1. Add author");
        System.out.println("2. Display all authors");
        System.out.println("0. Exit");
    }

    public void start() {

    }

}
