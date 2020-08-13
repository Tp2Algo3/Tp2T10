package OrderedChoice;

import Modelo.Preguntas.PreguntaOrderedChoice;
import Modelo.Preguntas.PreguntaVerdaderoOFalso;
import Modelo.Puntajes.PuntajeClasico;
import Modelo.Respuestas.Respuesta;
import Modelo.Respuestas.RespuestaCorrecta;
import Modelo.Respuestas.RespuestaIncorrecta;
import Modelo.Respuestas.RespuestaOrdenada;
import Modelo.Jugador.Jugador;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;

public class PreguntaOrderedChoiceTest {


    Jugador jugador1;
    Jugador jugador2;
    ArrayList<Respuesta> respuestasPosibles;
    ArrayList<Respuesta> respuestIngresadasJ1;
    ArrayList<Respuesta> respuestIngresadasJ2;
    PuntajeClasico puntajeClasico;
    PreguntaOrderedChoice preguntaOC;
    RespuestaOrdenada respuestaOrdenada;
    ArrayList<Integer> puntajes;
    ArrayList<ArrayList<Respuesta>> respuestasJugadores;


    @Test
    public void test01OrdenarlasEnElOrdeCorrectoDaUnPunto() {

        // Inicializo las variables
        jugador1 = new Jugador("Joel1");
        puntajeClasico = new PuntajeClasico();
        respuestasPosibles = new ArrayList<>();
        respuestIngresadasJ1 = new ArrayList<>();
        respuestasJugadores = new ArrayList<>();

        // Creo las respuestas y las aniado
        for (int i = 0; i < 3; i++) {
            respuestaOrdenada = new RespuestaOrdenada("Soy una opcion", i);
            respuestasPosibles.add(respuestaOrdenada);
            jugador1.aniadirRespuesta(respuestaOrdenada);
        }

        // Creo la pregunta y el jugador la responde
        preguntaOC = new PreguntaOrderedChoice(puntajeClasico, respuestasPosibles, "Soy una pregunta.");

        respuestIngresadasJ1 = jugador1.responderPregunta();
        respuestasJugadores.add(respuestIngresadasJ1);
        puntajes = preguntaOC.definirPuntajesDeJugadores(respuestasJugadores);
        jugador1.aumentarPuntaje(puntajes.get(0));

        assertEquals(1, jugador1.getPuntos());
    }

    @Test
    public void test02OrdenarAlgunasCorrectamenteYLasDemasNoDaCeroPuntos() {

        // Inicializo las variables
        jugador1 = new Jugador("Joel2");
        puntajeClasico = new PuntajeClasico();
        respuestasPosibles = new ArrayList<>();
        respuestasJugadores = new ArrayList<>();

        // El jugador pone la respuesta en el orden correcto
        respuestaOrdenada = new RespuestaOrdenada("Soy una opcion", 1);
        respuestasPosibles.add(respuestaOrdenada);
        jugador1.aniadirRespuesta(respuestaOrdenada);

        // El jugador pone la respuesta en el orden incorrecto
        respuestaOrdenada = new RespuestaOrdenada("Soy una opcion", 3);
        respuestasPosibles.add(respuestaOrdenada);
        jugador1.aniadirRespuesta(respuestaOrdenada);

        // El jugador pone la respuesta en el orden incorrecto
        respuestaOrdenada = new RespuestaOrdenada("Soy una opcion", 2);
        respuestasPosibles.add(respuestaOrdenada);
        jugador1.aniadirRespuesta(respuestaOrdenada);

        // Creo la pregunta y el jugador la responde
        preguntaOC = new PreguntaOrderedChoice(puntajeClasico, respuestasPosibles, "Soy una pregunta.");

        respuestIngresadasJ1 = jugador1.responderPregunta();
        respuestasJugadores.add(respuestIngresadasJ1);
        puntajes = preguntaOC.definirPuntajesDeJugadores(respuestasJugadores);
        jugador1.aumentarPuntaje(puntajes.get(0));

        assertEquals(0, jugador1.getPuntos());
    }

    @Test
    public void test03NoOrdenarTodasLasOpcionesDaCeroPuntos() {

        // Inicializo las variables
        jugador1 = new Jugador("Joel3");
        puntajeClasico = new PuntajeClasico();
        respuestasPosibles = new ArrayList<>();
        respuestasJugadores = new ArrayList<>();

        // Creo las respuestas y las aniado
        for (int i = 0; i < 3; i++) {
            respuestaOrdenada = new RespuestaOrdenada("Soy una opcion", i);
            respuestasPosibles.add(respuestaOrdenada);

            // El jugador solo ordena 2 respuestas
            if (i < 2) {
                jugador1.aniadirRespuesta(respuestaOrdenada);
            }

        }

        // Creo la pregunta y el jugador la responde
        preguntaOC = new PreguntaOrderedChoice(puntajeClasico, respuestasPosibles, "Soy una pregunta.");

        respuestIngresadasJ1 = jugador1.responderPregunta();
        respuestasJugadores.add(respuestIngresadasJ1);
        puntajes = preguntaOC.definirPuntajesDeJugadores(respuestasJugadores);
        jugador1.aumentarPuntaje(puntajes.get(0));

        assertEquals(0, jugador1.getPuntos());
    }

    @Test
    public void test04TodosLosJugadoresRespondenCorrectamenteYUsarExclusividadUnaSolaVezNoDaPuntos() {
        jugador1 = new Jugador("Manuel");
        jugador2 = new Jugador("Manuela");

        puntajeClasico = new PuntajeClasico();
        respuestasPosibles = new ArrayList<>();
        respuestIngresadasJ1 = new ArrayList<>();
        respuestasJugadores = new ArrayList<>();

        // Creo las respuestas y las aniado
        for (int i = 0; i < 3; i++) {
            respuestaOrdenada = new RespuestaOrdenada("Soy una opcion", i);
            respuestasPosibles.add(respuestaOrdenada);
            jugador1.aniadirRespuesta(respuestaOrdenada);
            jugador2.aniadirRespuesta(respuestaOrdenada);
        }

        // Creo la pregunta y el jugador la responde
        preguntaOC = new PreguntaOrderedChoice(puntajeClasico, respuestasPosibles, "Soy una pregunta.");

        // Un solo jugador uza exclusividad
        jugador1.utilizarExclusividad(preguntaOC);

        respuestIngresadasJ1 = jugador1.responderPregunta();
        respuestIngresadasJ2 = jugador2.responderPregunta();

        respuestasJugadores.add(respuestIngresadasJ1);
        respuestasJugadores.add(respuestIngresadasJ2);
        puntajes = preguntaOC.definirPuntajesDeJugadores(respuestasJugadores);
        jugador1.aumentarPuntaje(puntajes.get(0));
        jugador2.aumentarPuntaje(puntajes.get(1));

        assertEquals(0, jugador1.getPuntos());
        assertEquals(0, jugador2.getPuntos());
    }

    @Test
    public void test05SoloUnJugadorRespondeCorrectamenteYUsarExclusividadUnaSolaVezLeDuplicaLosPuntos() {
        jugador1 = new Jugador("Manuel");
        jugador2 = new Jugador("Manuela");

        puntajeClasico = new PuntajeClasico();
        respuestasPosibles = new ArrayList<>();
        respuestIngresadasJ1 = new ArrayList<>();
        respuestasJugadores = new ArrayList<>();

        // Creo las respuestas y las aniado
        for (int i = 0; i < 3; i++) {
            respuestaOrdenada = new RespuestaOrdenada("Soy una opcion", i);
            respuestasPosibles.add(respuestaOrdenada);
            jugador1.aniadirRespuesta(respuestaOrdenada);

            // El jugador 2 solo ordena 2 respuestas de 3 (puntaje == 0)
            if (i < 2) {
                jugador2.aniadirRespuesta(respuestaOrdenada);
            }
        }

        // Creo la pregunta y el jugador la responde
        preguntaOC = new PreguntaOrderedChoice(puntajeClasico, respuestasPosibles, "Soy una pregunta.");

        // Un solo jugador usa exclusividad
        jugador1.utilizarExclusividad(preguntaOC);

        respuestIngresadasJ1 = jugador1.responderPregunta();
        respuestIngresadasJ2 = jugador2.responderPregunta();

        respuestasJugadores.add(respuestIngresadasJ1);
        respuestasJugadores.add(respuestIngresadasJ2);
        puntajes = preguntaOC.definirPuntajesDeJugadores(respuestasJugadores);

        jugador1.aumentarPuntaje(puntajes.get(0));
        jugador2.aumentarPuntaje(puntajes.get(1));

        assertEquals(2, jugador1.getPuntos());
        assertEquals(0, jugador2.getPuntos());
    }

    @Test
    public void test06TodosLosJugadoresRespondenCorrectamenteYUsarExclusividadDosVecesNoDaPuntos() {
        jugador1 = new Jugador("Manuel");
        jugador2 = new Jugador("Manuela");

        puntajeClasico = new PuntajeClasico();
        respuestasPosibles = new ArrayList<>();
        respuestIngresadasJ1 = new ArrayList<>();
        respuestasJugadores = new ArrayList<>();

        // Creo las respuestas y las aniado
        for (int i = 0; i < 3; i++) {
            respuestaOrdenada = new RespuestaOrdenada("Soy una opcion", i);
            respuestasPosibles.add(respuestaOrdenada);
            jugador1.aniadirRespuesta(respuestaOrdenada);
            jugador2.aniadirRespuesta(respuestaOrdenada);
        }

        // Creo la pregunta y el jugador la responde
        preguntaOC = new PreguntaOrderedChoice(puntajeClasico, respuestasPosibles, "Soy una pregunta.");

        // Los dos jugadores usan exclusividad
        jugador1.utilizarExclusividad(preguntaOC);
        jugador2.utilizarExclusividad(preguntaOC);

        respuestIngresadasJ1 = jugador1.responderPregunta();
        respuestIngresadasJ2 = jugador2.responderPregunta();

        respuestasJugadores.add(respuestIngresadasJ1);
        respuestasJugadores.add(respuestIngresadasJ2);
        puntajes = preguntaOC.definirPuntajesDeJugadores(respuestasJugadores);
        jugador1.aumentarPuntaje(puntajes.get(0));
        jugador2.aumentarPuntaje(puntajes.get(1));

        assertEquals(0, jugador1.getPuntos());
        assertEquals(0, jugador2.getPuntos());
    }

    @Test
    public void test07SoloUnJugadorRespondeCorrectamenteYUsarExclusividadDosVecesLeCuadriplicaLosPuntos() {
        jugador1 = new Jugador("Manuel");
        jugador2 = new Jugador("Manuela");

        puntajeClasico = new PuntajeClasico();
        respuestasPosibles = new ArrayList<>();
        respuestIngresadasJ1 = new ArrayList<>();
        respuestasJugadores = new ArrayList<>();

        // Creo las respuestas y las aniado
        for (int i = 0; i < 3; i++) {
            respuestaOrdenada = new RespuestaOrdenada("Soy una opcion", i);
            respuestasPosibles.add(respuestaOrdenada);
            jugador1.aniadirRespuesta(respuestaOrdenada);

            // El jugador 2 solo ordena 2 respuestas de 3 (puntaje == 0)
            if (i < 2) {
                jugador2.aniadirRespuesta(respuestaOrdenada);
            }
        }

        // Creo la pregunta y el jugador la responde
        preguntaOC = new PreguntaOrderedChoice(puntajeClasico, respuestasPosibles, "Soy una pregunta.");

        // Los dos jugadores utilizan exclusividad
        jugador1.utilizarExclusividad(preguntaOC);
        jugador2.utilizarExclusividad(preguntaOC);

        respuestIngresadasJ1 = jugador1.responderPregunta();
        respuestIngresadasJ2 = jugador2.responderPregunta();

        respuestasJugadores.add(respuestIngresadasJ1);
        respuestasJugadores.add(respuestIngresadasJ2);
        puntajes = preguntaOC.definirPuntajesDeJugadores(respuestasJugadores);

        jugador1.aumentarPuntaje(puntajes.get(0));
        jugador2.aumentarPuntaje(puntajes.get(1));

        assertEquals(4, jugador1.getPuntos());
        assertEquals(0, jugador2.getPuntos());
    }

    @Test
    public void test08LaOrderedChoiceDebeTenerEntre5Y2Respuestas() {
        respuestasPosibles = new ArrayList<>();
        respuestaOrdenada = new RespuestaOrdenada("Soy una opcion", 0);
        respuestasPosibles.add(respuestaOrdenada);
        assertThrows(RuntimeException.class, () -> new PreguntaOrderedChoice(new PuntajeClasico(),respuestasPosibles, "Soy una pregunta"));
        for (int i = 1; i < 6; i++) {
            respuestaOrdenada = new RespuestaOrdenada("Soy una opcion", i);
            respuestasPosibles.add(respuestaOrdenada);
        }
        assertThrows(RuntimeException.class, () -> new PreguntaOrderedChoice(new PuntajeClasico(),respuestasPosibles, "Soy un pregunta"));
    }
}
