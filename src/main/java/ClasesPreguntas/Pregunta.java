package ClasesPreguntas;

import java.util.ArrayList;
import ClasesPreguntas.Puntajes.Puntaje;

public abstract class Pregunta {

    protected ArrayList<Respuesta> respuestasCorrectas;
    protected Puntaje tipoPuntaje;
    protected ArrayList<Respuesta> respuestasPosibles;
    protected String contenido;

    public Pregunta(ArrayList<Respuesta> respuestasCorrectas, Puntaje tipoPuntaje, ArrayList<Respuesta> respuestasPosibles, String pregunta) {
        this.respuestasCorrectas = respuestasCorrectas;
        this.tipoPuntaje = tipoPuntaje;
        this.contenido = pregunta;
        this.respuestasPosibles = respuestasPosibles;
    }
    public abstract int calcularPuntaje(ArrayList<Respuesta> respuestas);
}