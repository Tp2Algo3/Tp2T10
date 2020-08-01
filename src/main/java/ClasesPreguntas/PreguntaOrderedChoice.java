package ClasesPreguntas;

import ClasesPreguntas.Puntajes.Puntaje;

import java.util.ArrayList;

public class PreguntaOrderedChoice extends Pregunta{

    public PreguntaOrderedChoice(Puntaje tipoPuntaje, ArrayList<Respuesta> respuestasOrdenadas, String pregunta){
        super(tipoPuntaje, respuestasOrdenadas, pregunta);
        if(respuestasPosibles.size() > 5 || respuestasPosibles.size() < 2)
            throw new RuntimeException("Cantidad de respuestas posibles inválida.");
    }

    @Override
    public int calcularPuntaje(ArrayList<Respuesta> respuestasDelUsuario) {
        boolean estaOrdenada = true;

        return 2;
    }
}
