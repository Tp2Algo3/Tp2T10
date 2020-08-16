package Modelo.Excepciones;

public class MultiplicadorEnUsoException extends RuntimeException {
    public MultiplicadorEnUsoException() {
        super ("Ya hay un multiplicador en uso.");
    }
}
