package Modelo.Excepciones;

public class NoPuedoClonarException extends RuntimeException {

    public NoPuedoClonarException(){
        super("No se puede clonar al objeto.");
    }
}
