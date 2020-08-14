package Vista.Layouts;

import Modelo.Turnos.Temporizador;
import Modelo.Preguntas.Pregunta;
import Modelo.Preguntas.PreguntaGroupChoice;
import Modelo.Jugador.Jugador;
import Modelo.Preguntas.PreguntaOrderedChoice;
import Modelo.Preguntas.PreguntaVerdaderoOFalso;
import javafx.scene.layout.StackPane;


import java.util.ArrayList;

public class PreguntaYRespuesta{

    public static StackPane getLayout(Pregunta pregunta, ArrayList<Jugador> jugadores, Jugador jugadorActual, Temporizador temporizador){
        if (pregunta.getClass() == PreguntaOrderedChoice.class) {
            return LayoutOrderedChoice.getLayout(pregunta, jugadores, jugadorActual, temporizador);
        }
        if (pregunta.getClass() == PreguntaGroupChoice.class) {
            return LayoutGroupChoice.getLayout((PreguntaGroupChoice) pregunta, jugadores, jugadorActual, temporizador);
        }
        if (pregunta.getClass() == PreguntaVerdaderoOFalso.class){
            return LayoutVerdaderoOFalso.getLayout(pregunta, jugadores, jugadorActual, temporizador);
        }
        return LayoutMultipleChoice.getLayout(pregunta,jugadores,jugadorActual,temporizador);
    }

}
