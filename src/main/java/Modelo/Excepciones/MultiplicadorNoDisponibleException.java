package Modelo.Excepciones;

public class MultiplicadorNoDisponibleException extends RuntimeException {
    public MultiplicadorNoDisponibleException() {
        super("El jugador no posee el multiplicador con el id indicado.");
    }
}
