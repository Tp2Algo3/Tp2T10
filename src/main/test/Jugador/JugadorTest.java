package Jugador;

import ClasesPreguntas.Respuestas.Respuesta;
import ClasesPreguntas.Respuestas.RespuestaCorrecta;
import Jugador.Potenciadores.MultiplicadorPorDos;
import Jugador.Potenciadores.MultiplicadorPorTres;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JugadorTest {

    Jugador jugador;
    Respuesta respuesta;

    @Test
    public void test01UnJugadorSumaUnaCantidadDePuntosYSeSumanASuPuntajeActual(){
        jugador = new Jugador ("Jugador");
        jugador.aumentarPuntaje(10);
        assertEquals(10,jugador.getPuntos());
        jugador.aumentarPuntaje(5);
        assertEquals(15,jugador.getPuntos());
    }

    @Test
    public void test02UnJugadorAniadeUnaRespuestaASuListaYSeAniadeCorrectamente(){
        jugador = new Jugador ("Jugador");
        jugador.aniadirRespuesta(new RespuestaCorrecta("Respuesta"));
        assertEquals(1,(jugador.responderPregunta()).size());
    }

    @Test
    public void test03UnJugadorBorraUnaRespuestaDeSuListaYSeBorraCorrectamente(){
        jugador = new Jugador ("Jugador");
        respuesta = new RespuestaCorrecta("Respuesta");
        jugador.aniadirRespuesta(respuesta);
        jugador.eliminarRespuesta(respuesta);
        assertEquals(0,(jugador.responderPregunta()).size());
    }

    @Test
    public void test04UnJugadorUtilizaUnPotenciadorYEsteSeUtiliza(){
        jugador = new Jugador("Jugador");
        jugador.utilizarPotenciador(MultiplicadorPorDos.class);
        jugador.aumentarPuntaje(2);
        assertEquals(4,jugador.getPuntos());
    }

    @Test
    public void test05UnJugadorQuiereUtilizarUnPotenciadorQueNoTieneYNoSeLeUtiliza(){
        jugador = new Jugador("Jugador");
        jugador.utilizarPotenciador(MultiplicadorPorTres.class);
        jugador.aumentarPuntaje(2);
        jugador.utilizarPotenciador(MultiplicadorPorTres.class);
        jugador.aumentarPuntaje(2);
        assertEquals(8,jugador.getPuntos());
    }

    @Test
    public void test06UnJugadorContestaLaPreguntaSuListaSeReseteaYPuedeAgregarNuevasRespuestas(){
        jugador = new Jugador("Jugador");
        respuesta = new RespuestaCorrecta("Soy Correcta");
        jugador.aniadirRespuesta(respuesta);
        jugador.responderPregunta(); //Se resetea
        jugador.aniadirRespuesta(respuesta);
        jugador.aniadirRespuesta(respuesta);
        assertEquals(2,jugador.responderPregunta().size());
    }
}
