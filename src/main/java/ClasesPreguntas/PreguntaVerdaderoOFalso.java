package ClasesPreguntas;

import java.util.ArrayList;
import ClasesPreguntas.Puntajes.*;

public class PreguntaVerdaderoOFalso extends Pregunta{

    public PreguntaVerdaderoOFalso(ArrayList<Respuesta> respuestasCorrectas, Puntaje tipoPuntaje, ArrayList<Respuesta> respuestasPosibles, String pregunta){
        super(respuestasCorrectas, tipoPuntaje, respuestasPosibles, pregunta);
    }

    @Override
    public int calcularPuntaje(ArrayList<Respuesta> respuestasIngresadas) {
        int cantRespuestasCorrectas = 0;
        for (Respuesta resp:respuestasIngresadas){
            if (resp.pertenece(respuestasCorrectas))
                cantRespuestasCorrectas++;
        }
        return (this.tipoPuntaje.calcularPuntaje(cantRespuestasCorrectas,respuestasCorrectas.size(),respuestasIngresadas.size()));
    }
}
