package ClasesPreguntas;

import java.util.List;
import ClasesPreguntas.Puntajes.Puntaje;

public abstract class Pregunta{

    protected List<Respuesta> respuestasCorrectas;
    protected Puntaje tipoPuntaje;
    protected List<Respuesta> respuestasPosibles;
    protected String contenido;

    public abstract int calcularPuntaje(List<Respuesta> respuestas);
}