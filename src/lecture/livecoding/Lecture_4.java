package lecture.livecoding;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Lecture_4 {
    public static void main(String[] args) {

        // Se creeaza o instanta (prin new) a unei clase anonime care este
        // derivata din clasa AbstractRepository<Square>
        // Clasa este concreta (non-abstracta) deoarece sunt implementate toate
        // metodele abstracte

//        IRepository<Square> repo = new AbstractRepository<Square>() {
//            @Override
//            public void store(Square element) throws RepositoryException {
//
//            }
//
//            @Override
//            public boolean delete(Square element) {
//                return false;
//            }
//
//            @Override
//            public Square find(int elementId) {
//                return null;
//            }
//
//            @Override
//            public Collection<Square> getAll() {
//                return List.of();
//            }
//        };

        IRepository<Square> repo = new MemoryRepository<>();
        try {
            repo.store(new Square(100, "my square", 3));
            repo.store(UnitSquare.getInstance());
            repo.store(UnitSquare.getInstance());

            // var -- compilatorul determina tipul corect al variabilei si il
            // asigneaza
//            for (var sq : repo.getAll()) {
//                System.out.println(sq);
//            }


            Iterator<Square> iterator = repo.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }

            for (var elem : repo) {
                System.out.println(elem);
            }


        } catch (RepositoryException e) {
//            System.out.println(e);
            System.err.println(e);
        }
    }
}
