package exception;

public class DuplicateMemberExeception extends RuntimeException {
    public DuplicateMemberExeception(String message) {
        super(message);
    }
}
