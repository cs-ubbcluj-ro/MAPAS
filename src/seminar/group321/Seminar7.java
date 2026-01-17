package seminar.group321;

public class Seminar7 {
    /*
     Sabloane de proiectare (eng. Design Patterns)
     - sunt solutii comun agreate pentru probleme care apar des in
     scrierea de programe mai mari

     De unde puteti afla mai multe
        1. Cursul optional de Design Pattern (an 3, semestrul 2)
        2. https://refactoring.guru/design-patterns

     Sabloane de proiectare "traditionale"
        Creational -- se refera la moduri flexibile pentru crearea
        obiectelor
            -> Sablonul "Builder" (https://refactoring.guru/design-patterns/builder)
                - Permite crearea obiectelor pas cu pas
            -> Sablonul "Singleton"

        Structural -- se refera la modul in care structuram mai multe clase
        pentru a realiza ceva

            -> Sablonul Composite (https://refactoring.guru/design-patterns/composite)
                - Exemplu: toate interfetele grafice folosind JavaFX (si nu numai) folosesc
                acest sablon de proiectare

            -> Sablonul Decorator (https://refactoring.guru/design-patterns/decorator)

        Behavioural -- se refera la modul in care proiectam comportamentul claselor

            -> Sablonul Iterator
            -> Sablonul Observer (FXCollections.observableList())
     */



    public static void main(String[] args) {
        // Exemplu Java clasic pentru sablonul Builder
        StringBuilder sb = new StringBuilder();

        /*
        Obiectele String in Java sunt immutable (odata creat, un String
        nu poate fi modificat => orice operatie returneaza un String nou)

         */
        String s = sb.append("a").append(1).append("b").append(2).append("c").toString();

    }

//    Email = EmailBuilder.getInstance().from("arthur@cs.ro").to("mapas321@google.com").to("mapas322@google.com").
//    subject("hello").body("...").create();
}
