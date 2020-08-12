package Modelo.Archivos;

import Modelo.Preguntas.Pregunta;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public interface CargadorDePreguntas {
    ArrayList<Pregunta> leerPreguntas() throws FileNotFoundException;
}
