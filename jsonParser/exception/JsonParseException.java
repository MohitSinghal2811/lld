package jsonParser.exception;

public class JsonParseException extends RuntimeException {
    public JsonParseException(String message) {
        super("Unexpected Token " + message);
    }
}