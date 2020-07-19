package ClasesPreguntas;

import java.util.ArrayList;
import java.util.List;
import ClasesPreguntas.Puntajes.*;

public class PreguntaOpcionMultiple extends Pregunta{

    public PreguntaOpcionMultiple(ArrayList<Respuesta> respuestasCorrectas, Puntaje tipoPuntaje, ArrayList<Respuesta> respuestasPosibles, String pregunta){
        this.respuestasCorrectas = respuestasCorrectas;
        this.tipoPuntaje = tipoPuntaje;
        this.contenido = pregunta;
        this.respuestasPosibles = respuestasPosibles;
    }

    public int calcularPuntaje(ArrayList<Respuesta> respuestasDelUsuario) {
        int cantRespuestasCorrectas = 0;
        for (Respuesta resp:respuestasDelUsuario){
            if (resp.pertenece(respuestasCorrectas))
                cantRespuestasCorrectas++;
        }
        return (this.tipoPuntaje.calcularPuntaje(cantRespuestasCorrectas, respuestasCorrectas.size(), respuestasDelUsuario.size()));
    }

}
