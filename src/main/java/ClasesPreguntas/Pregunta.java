package ClasesPreguntas;

import java.util.ArrayList;
import ClasesPreguntas.Puntajes.Puntaje;

public abstract class Pregunta{

    protected ArrayList<Respuesta> respuestasCorrectas;
    protected Puntaje tipoPuntaje;
    protected ArrayList<Respuesta> respuestasPosibles;
    protected String contenido;

    public abstract int calcularPuntaje(ArrayList<Respuesta> respuestas);
}