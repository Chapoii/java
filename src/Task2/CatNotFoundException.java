package Task2;

public class CatNotFoundException extends IllegalArgumentException{
    public CatNotFoundException() {
        super();
    }

    public CatNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CatNotFoundException(String message) {
        super(message);
    }

    public CatNotFoundException(Throwable cause) {
        super(cause);
    }
}
