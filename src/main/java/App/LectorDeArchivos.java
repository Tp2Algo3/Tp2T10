package App;

import Preguntas.*;
import Respuestas.Respuesta;

import java.util.ArrayList;

public class LectorDeArchivos implements CargadorDePreguntas{

    @Override
    public ArrayList<Pregunta> leerPreguntas(){
        //While !termineDeLeer
        ArrayList<Respuesta> respuestas = leerRespuestas();
        //CrearPregunta
        //Añadir A lista
        //Return lista
        return null;
    }

    private ArrayList<Respuesta> leerRespuestas(){
        return null;
    }

}
