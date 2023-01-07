package exeptions;

public final class UnauthorizedUserException extends RuntimeException {
    public UnauthorizedUserException(String msg) {
        super(msg);
    }
}
