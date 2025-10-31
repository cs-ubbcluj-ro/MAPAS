package lecture.test;

import lecture.livecoding.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MemoryRepositoryTest {
    @Test
    public void repositoryTest() throws RepositoryException {
        IRepository<Shape> repo = new MemoryRepository<>();
        assertEquals(0, repo.getAll().size());
        repo.store(UnitSquare.getInstance());
        assertEquals(1, repo.getAll().size());
    }
}
