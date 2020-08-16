package JugadorTest;

import Modelo.Jugador.Jugador;
import Modelo.Potenciadores.MultiplicadorPorDos;
import Modelo.Potenciadores.MultiplicadorPorTres;
import Modelo.Preguntas.PreguntaVerdaderoOFalso;
import Modelo.Puntajes.PuntajeClasico;
import Modelo.Respuestas.Respuesta;
import Modelo.Respuestas.RespuestaCorrecta;
import Modelo.Respuestas.RespuestaIncorrecta;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

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
        jugador.utilizarMultiplicador(new MultiplicadorPorDos());
        jugador.aumentarPuntaje(2);
        assertEquals(4,jugador.getPuntos());
    }

    @Test
    public void test05UnJugadorQuiereUtilizarUnPotenciadorQueNoTieneYNoSeLeUtiliza(){
        jugador = new Jugador("Jugador");
        jugador.utilizarMultiplicador(new MultiplicadorPorTres());
        jugador.aumentarPuntaje(2);
        assertThrows(RuntimeException.class, ()->jugador.utilizarMultiplicador(new MultiplicadorPorTres()));
    }

    @Test
    public void test06UnJugadorContestaLaPreguntaSuListaSeReseteaYPuedeAgregarNuevasRespuestas(){
        jugador = new Jugador("Jugador");
        respuesta = new RespuestaCorrecta("Soy Correcta");
        jugador.aniadirRespuesta(respuesta);
        jugador.responderPregunta();
        jugador.borrarRespuestas();
        jugador.aniadirRespuesta(respuesta);
        jugador.aniadirRespuesta(respuesta);
        assertEquals(2,jugador.responderPregunta().size());
    }

    @Test
    public void test07AlUtilizarExclusividadElJugadorPierdeUnUsoDelMismo(){
        //Inicializacion
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(new RespuestaIncorrecta("falso"));
        respuestas.add(new RespuestaCorrecta("verdadero"));
        jugador = new Jugador("Juancito");
        PreguntaVerdaderoOFalso vof = new PreguntaVerdaderoOFalso(new PuntajeClasico(), respuestas, "Hola");

        //Act Y Assert
        jugador.utilizarExclusividad(vof);
        assertEquals(1,jugador.getUsosExclusividad());
        jugador.utilizarExclusividad(vof);
        assertEquals(0,jugador.getUsosExclusividad());
    }

    @Test
    public void test07AlUtilizarExclusividadTresVeceElJugadorLanzaError(){
        //Inicializacion
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(new RespuestaIncorrecta("falso"));
        respuestas.add(new RespuestaCorrecta("verdadero"));
        jugador = new Jugador("Juancito");
        PreguntaVerdaderoOFalso vof = new PreguntaVerdaderoOFalso(new PuntajeClasico(), respuestas, "Hola");

        //Act Y Assert
        jugador.utilizarExclusividad(vof);
        assertEquals(1,jugador.getUsosExclusividad());
        jugador.utilizarExclusividad(vof);
        assertEquals(0,jugador.getUsosExclusividad());
        assertThrows(RuntimeException.class, ()->jugador.utilizarExclusividad(vof));

    }
}
