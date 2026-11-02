package lecture.livecoding.repository;

public class RepositoryFileException extends RepositoryException {
    public RepositoryFileException(String message) {
        super(message);
    }

    public RepositoryFileException(String message, Throwable cause) {
        super(message, cause);
    }
}
