package lecture.livecoding.test;

import lecture.livecoding.domain.Rectangle;
import lecture.livecoding.domain.Square;
import lecture.livecoding.domain.UnitSquare;
import lecture.livecoding.repository.MemoryRepository;
import lecture.livecoding.repository.RepositoryException;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemoryRepositoryTest {

    @Before
    public void beforeX() {
        // FIXME !?
        // TODO What is going on here?
        System.out.println("Before");
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("Before each");
    }


    @Test
    public void repoTest() {
        MemoryRepository<Rectangle> repo = new MemoryRepository<>();
        Assertions.assertEquals(0, repo.size());
    }

    @Test
    public void repoOperationsTest() {
        MemoryRepository<Rectangle> repo = new MemoryRepository<>();
        Assertions.assertEquals(0, repo.size());
        try {
            repo.store(UnitSquare.getInstance());
        } catch (RepositoryException e) {
            // Exception should not be thrown here
            Assertions.fail("no exception should be here");
        }

        try {
            repo.store(new Square(200, "back to square one", 2));
        } catch (RepositoryException e) {
            Assertions.fail("no exception should be here");
        }

        Assertions.assertEquals(2, repo.size());
    }

}
