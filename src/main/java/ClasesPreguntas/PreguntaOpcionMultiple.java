package ClasesPreguntas;

import java.util.ArrayList;
import ClasesPreguntas.Puntajes.*;

public class PreguntaOpcionMultiple extends Pregunta{

    public PreguntaOpcionMultiple(ArrayList<Respuesta> respuestasCorrectas, Puntaje tipoPuntaje, ArrayList<Respuesta> respuestasPosibles, String pregunta){
        super(respuestasCorrectas, tipoPuntaje, respuestasPosibles, pregunta);
    }

    public int calcularPuntaje(ArrayList<Respuesta> respuestasDelUsuario) {
        int cantRespuestasCorrectas;
        cantRespuestasCorrectas =(int) respuestasDelUsuario.stream().filter(respuesta -> respuesta.esCorrecta()).count();
        return (this.tipoPuntaje.calcularPuntaje(cantRespuestasCorrectas, respuestasCorrectas.size(), respuestasDelUsuario.size()));
    }

}
