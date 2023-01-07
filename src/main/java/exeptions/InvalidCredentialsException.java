package exeptions;

public final class InvalidCredentialsException extends RuntimeException {
    public InvalidCredentialsException(String msg) {
        super(msg);
    }
}
