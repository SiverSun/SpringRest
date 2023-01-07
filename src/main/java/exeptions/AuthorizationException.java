package exeptions;

public final class AuthorizationException extends RuntimeException {
    public AuthorizationException(String msg) {
        super(msg);
    }
}
