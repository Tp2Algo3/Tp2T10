package Modelo.Excepciones;

public class PuntajeInvalidoExcepcion extends RuntimeException{
    public PuntajeInvalidoExcepcion(String mensaje){
        super(mensaje);
    }
}
