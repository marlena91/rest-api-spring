package pl.wsb.restexample.exceeptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException() {
        super("Nie znaleziono zasobu");
    }
}
