package Modelo.Excepciones;

public class NoQuedanExclusividadesException extends RuntimeException {

    public NoQuedanExclusividadesException() {
        super("No quedan usos de exclusividad en el jugador.");
    }
}
