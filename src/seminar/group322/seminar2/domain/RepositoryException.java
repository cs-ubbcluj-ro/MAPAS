package seminar.group322.seminar2.domain;

public class RepositoryException extends Exception {
    public RepositoryException(Throwable cause) {
        super(cause);
    }

    public RepositoryException(String message) {
        super(message);

    }
}
