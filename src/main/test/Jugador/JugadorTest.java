package Jugador;

import Preguntas.PreguntaVerdaderoOFalso;
import Puntajes.PuntajeClasico;
import Respuestas.Respuesta;
import Respuestas.RespuestaCorrecta;
import Respuestas.RespuestaIncorrecta;
import Potenciadores.MultiplicadorPorDos;
import Potenciadores.MultiplicadorPorTres;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

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
        jugador.utilizarMultiplicador(MultiplicadorPorDos.class);
        jugador.aumentarPuntaje(2);
        assertEquals(4,jugador.getPuntos());
    }

    @Test
    public void test05UnJugadorQuiereUtilizarUnPotenciadorQueNoTieneYNoSeLeUtiliza(){
        jugador = new Jugador("Jugador");
        jugador.utilizarMultiplicador(MultiplicadorPorTres.class);
        jugador.aumentarPuntaje(2);
        jugador.utilizarMultiplicador(MultiplicadorPorTres.class);
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

    @Test
    public void test07AlUtilizarExclusividadElJugadorPierdeUnUsoDelMismo(){
        //Inicializacion
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(new RespuestaIncorrecta("asd"));
        respuestas.add(new RespuestaCorrecta("qwe"));
        jugador = new Jugador("Juancito");
        PreguntaVerdaderoOFalso vof = new PreguntaVerdaderoOFalso(new PuntajeClasico(), respuestas, "Hola");

        //Act Y Assert
        jugador.utilizarExclusividad(vof);
        assertEquals(1,jugador.getUsosExclusividad());
        jugador.utilizarExclusividad(vof);
        assertEquals(0,jugador.getUsosExclusividad());
        jugador.utilizarExclusividad(vof);
        assertEquals(0,jugador.getUsosExclusividad());
    }
}
