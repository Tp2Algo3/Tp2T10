package ClasesPreguntas;

import java.util.ArrayList;
import ClasesPreguntas.Puntajes.*;

public class PreguntaOpcionMultiple extends Pregunta{

    public PreguntaOpcionMultiple(ArrayList<Respuesta> respuestasCorrectas, Puntaje tipoPuntaje, ArrayList<Respuesta> respuestasPosibles, String pregunta){
        super(respuestasCorrectas, tipoPuntaje, respuestasPosibles, pregunta);
    }

    public int calcularPuntaje(ArrayList<Respuesta> respuestasDelUsuario) {
        int cantRespuestasCorrectas = 0;
        //VER SI NO SE PUEDE HACER CON UN ESTILO DE COUNT DE SMALLTALK
        for (Respuesta resp:respuestasDelUsuario){
            if (resp.esCorrecta())
                cantRespuestasCorrectas++;
        }
        return (this.tipoPuntaje.calcularPuntaje(cantRespuestasCorrectas, respuestasCorrectas.size(), respuestasDelUsuario.size()));
    }

}
