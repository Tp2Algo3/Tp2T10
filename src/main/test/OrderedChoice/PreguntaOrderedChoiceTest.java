package OrderedChoice;

import ClasesPreguntas.PreguntaOrderedChoice;
import ClasesPreguntas.Puntajes.PuntajeClasico;
import ClasesPreguntas.Respuesta;
import ClasesPreguntas.RespuestaOrdenada;
import Jugador.Jugador;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

public class PreguntaOrderedChoiceTest {

    Jugador jugador;
    ArrayList<Respuesta> respuestasPosibles;
    ArrayList<Respuesta> respuestasIngresadas;
    PuntajeClasico puntajeClasico;
    PreguntaOrderedChoice preguntaOC;
    RespuestaOrdenada respuestaOrdenada;


    @Test
    public void test01OrdenarlasEnElOrdeCorrectoDaUnPunto() {

        // Inicializo las variables
        jugador = new Jugador("Joel1");
        puntajeClasico = new PuntajeClasico();
        respuestasPosibles = new ArrayList<>();
        respuestasIngresadas = new ArrayList<>();

        // Creo las respuestas y las aniado
        for (int i = 0; i < 3; i++) {
            respuestaOrdenada = new RespuestaOrdenada("Soy una opcion", i);
            respuestasPosibles.add(respuestaOrdenada);
            jugador.aniadirRespuesta(respuestaOrdenada);
        }

        // Creo la pregunta y el jugador la responde
        preguntaOC = new PreguntaOrderedChoice(puntajeClasico, respuestasPosibles, "Soy una pregunta.");

        respuestasIngresadas = jugador.responderPregunta();
        jugador.aumentarPuntaje(preguntaOC.calcularPuntaje(respuestasIngresadas));

        assertEquals(1, jugador.getPuntos());
    }

    @Test
    public void test02OrdenarAlgunasCorrectamenteYLasDemasNoDaCeroPuntos() {

        // Inicializo las variables
        jugador = new Jugador("Joel2");
        puntajeClasico = new PuntajeClasico();
        respuestasPosibles = new ArrayList<>();

        // El jugador pone la respuesta en el orden correcto
        respuestaOrdenada = new RespuestaOrdenada("Soy una opcion", 1);
        respuestasPosibles.add(respuestaOrdenada);
        jugador.aniadirRespuesta(respuestaOrdenada);

        // El jugador pone la respuesta en el orden incorrecto
        respuestaOrdenada = new RespuestaOrdenada("Soy una opcion", 3);
        respuestasPosibles.add(respuestaOrdenada);
        jugador.aniadirRespuesta(respuestaOrdenada);

        // El jugador pone la respuesta en el orden incorrecto
        respuestaOrdenada = new RespuestaOrdenada("Soy una opcion", 2);
        respuestasPosibles.add(respuestaOrdenada);
        jugador.aniadirRespuesta(respuestaOrdenada);

        // Creo la pregunta y el jugador la responde
        preguntaOC = new PreguntaOrderedChoice(puntajeClasico, respuestasPosibles, "Soy una pregunta.");

        respuestasIngresadas = jugador.responderPregunta();
        jugador.aumentarPuntaje(preguntaOC.calcularPuntaje(respuestasIngresadas));

        assertEquals(0, jugador.getPuntos());
    }

    @Test
    public void test03NoOrdenarTodasLasOpcionesDaCeroPuntos() {

        // Inicializo las variables
        jugador = new Jugador("Joel3");
        puntajeClasico = new PuntajeClasico();
        respuestasPosibles = new ArrayList<>();

        // Creo las respuestas y las aniado
        for (int i = 0; i < 3; i++) {
            respuestaOrdenada = new RespuestaOrdenada("Soy una opcion", i);
            respuestasPosibles.add(respuestaOrdenada);

            // El jugador solo ordena 2 respuestas
            if (i < 2) {
                jugador.aniadirRespuesta(respuestaOrdenada);
            }

        }

        // Creo la pregunta y el jugador la responde
        preguntaOC = new PreguntaOrderedChoice(puntajeClasico, respuestasPosibles, "Soy una pregunta.");

        respuestasIngresadas = jugador.responderPregunta();
        jugador.aumentarPuntaje(preguntaOC.calcularPuntaje(respuestasIngresadas));

        assertEquals(0, jugador.getPuntos());
    }
}
