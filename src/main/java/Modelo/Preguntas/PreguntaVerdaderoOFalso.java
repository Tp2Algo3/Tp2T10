package Modelo.Preguntas;

import java.util.ArrayList;

import Modelo.Respuestas.Respuesta;
import Modelo.Puntajes.Puntaje;

public class PreguntaVerdaderoOFalso extends Pregunta{

    private boolean respuestasSonVoF(ArrayList<Respuesta> respuestasPosibles){
        boolean esVoF=true;
        Respuesta respuesta1=respuestasPosibles.get(0);
        Respuesta respuesta2=respuestasPosibles.get(1);
        //No pueden ser las dos verdadero o las dos falso
        if (respuesta1.getContenido().toUpperCase().equals(respuesta2.getContenido().toUpperCase())){
            esVoF = false;
        }
        //Una debe ser veradero
        if (!(respuesta1.getContenido().toLowerCase()).equals("verdadero") && !(respuesta1.getContenido().toLowerCase()).equals("falso")){
            esVoF = false;
        }
        //Una debe ser falso
        if(!(respuesta2.getContenido().toLowerCase()).equals("verdadero") && !(respuesta2.getContenido().toLowerCase()).equals("falso")){
            esVoF = false;
        }
        return esVoF;
    }

    public PreguntaVerdaderoOFalso(Puntaje tipoPuntaje, ArrayList<Respuesta> respuestasPosibles, String pregunta){
        super(tipoPuntaje, respuestasPosibles, pregunta);
        if(respuestasPosibles.size() != 2)
            throw new IllegalArgumentException("Cantidad de respuestas posibles inválida. Deben ser 2. Pregunta VerdaderoOFalso.");
        if(!respuestasSonVoF(respuestasPosibles))
            throw new IllegalArgumentException("Las únicas respuestas permitidas son Verdadero o Falso, y sin repetirlas.");
    }

}
