package vendingMachine.exception;

public class OutOfProductsException extends RuntimeException {
    public OutOfProductsException() {
    }

    public OutOfProductsException(String message) {
        super(message);
    }
}
