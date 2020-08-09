package App;

import Preguntas.Pregunta;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public interface CargadorDePreguntas {
    ArrayList<Pregunta> leerPreguntas() throws FileNotFoundException;
}
