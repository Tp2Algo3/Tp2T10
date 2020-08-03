package ClasesPreguntas.Preguntas;

import java.util.ArrayList;
import ClasesPreguntas.Puntajes.Puntaje;
import ClasesPreguntas.Respuestas.Respuesta;

public abstract class Pregunta {

    protected Puntaje tipoPuntaje;
    protected ArrayList<Respuesta> respuestasPosibles;
    protected String contenido;

    public Pregunta(Puntaje tipoPuntaje, ArrayList<Respuesta> respuestasPosibles, String pregunta) {
        this.tipoPuntaje = tipoPuntaje;
        this.contenido = pregunta;
        this.respuestasPosibles = respuestasPosibles;
    }

    public int calcularPuntaje(ArrayList<Respuesta> respuestasDelUsuario) {
        int cantRespuestasCorrectasDelUsuario, cantRespuestasCorrectasDeLaPregunta;
        cantRespuestasCorrectasDeLaPregunta =(int) respuestasPosibles.stream().filter(respuesta -> respuesta.esCorrecta()).count();
        cantRespuestasCorrectasDelUsuario =(int) respuestasDelUsuario.stream().filter(respuesta -> respuesta.esCorrecta()).count();
        return (this.tipoPuntaje.calcularPuntaje(cantRespuestasCorrectasDelUsuario, cantRespuestasCorrectasDeLaPregunta, respuestasDelUsuario.size()));
    }

    public String getContenido(){
        return contenido;
    }
}