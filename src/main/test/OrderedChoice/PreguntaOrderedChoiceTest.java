package OrderedChoice;

import ClasesPreguntas.PreguntaOrderedChoice;
import ClasesPreguntas.Puntajes.PuntajeClasico;
import ClasesPreguntas.Respuesta;
import ClasesPreguntas.RespuestaCorrecta;
import Jugador.Jugador;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

public class PreguntaOrderedChoiceTest {

    Jugador jugador;
    ArrayList<Respuesta> respuestasPosibles;
    ArrayList<Respuesta> respuestasIngresadas;
    Respuesta respuestaCorrecta;
    PuntajeClasico puntajeClasico;
    PreguntaOrderedChoice preguntaOC;

    @Test
    public void test01ResponderEnElOrdenCorrectoDaUnPunto() {
        jugador = new Jugador("Joel");
        puntajeClasico = new PuntajeClasico();

        for (int i = 0; i < 3; i++) {
            respuestaCorrecta = new RespuestaCorrecta("Soy correcta");
            respuestasPosibles.add(respuestaCorrecta);
            jugador.aniadirRespuesta(respuestaCorrecta);
        }

        preguntaOC = new PreguntaOrderedChoice(puntajeClasico, respuestasPosibles, "Soy una pregunta.");

        respuestasIngresadas = jugador.responderPregunta();
        jugador.aumentarPuntaje(preguntaOC.calcularPuntaje(respuestasIngresadas));

        assertEquals(1, jugador.getPuntos());

    }
}
