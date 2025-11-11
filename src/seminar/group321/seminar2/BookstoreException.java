package seminar.group321.seminar2;

public class BookstoreException extends Exception {
    public BookstoreException(Throwable cause, String message) {
        super(message, cause);
    }

    public BookstoreException(String message) {
        super(message);
    }
}
