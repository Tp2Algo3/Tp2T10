package ClasesPreguntas;

import java.util.ArrayList;
import ClasesPreguntas.Puntajes.*;

public class PreguntaVerdaderoOFalso extends Pregunta{

    public PreguntaVerdaderoOFalso(ArrayList<Respuesta> respuestasCorrectas, Puntaje tipoPuntaje, ArrayList<Respuesta> respuestasPosibles, String pregunta){
        super(respuestasCorrectas, tipoPuntaje, respuestasPosibles, pregunta);
    }

    @Override
    public int calcularPuntaje(ArrayList<Respuesta> respuestasIngresadas) {
        int cantRespuestasCorrectas;
        cantRespuestasCorrectas = (int) respuestasIngresadas.stream().filter(respuesta -> respuesta.esCorrecta()).count();
        return (this.tipoPuntaje.calcularPuntaje(cantRespuestasCorrectas,respuestasCorrectas.size(),respuestasIngresadas.size()));
    }
}
