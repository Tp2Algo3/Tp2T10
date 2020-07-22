package VoF;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import ClasesPreguntas.Puntajes.*;
import ClasesPreguntas.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import Jugador.Jugador;

public class PreguntaVerdaderoOFalsoTest {

    private Pregunta VoF;
    ArrayList <Respuesta> respuestasIngresadas;
    ArrayList<Respuesta> respuestasPosibles;
    PuntajeClasico puntajeClasico;


    @Test
    public void test01DadoUnaRespuestaCorrectaDevolverUnPunto(){
        respuestasIngresadas = new ArrayList<>();
        respuestasPosibles = new ArrayList<>();
        PuntajeClasico puntajeClasico =  mock(PuntajeClasico.class);
        Respuesta respuestaCorrecta = mock(Respuesta.class);
        Respuesta respuestaIncorrecta = mock(Respuesta.class);

        respuestasIngresadas.add(respuestaCorrecta);
        respuestasPosibles.add(respuestaCorrecta);
        respuestasPosibles.add(respuestaIncorrecta);

        when(respuestaCorrecta.pertenece(respuestasIngresadas)).thenReturn(true);
        when(respuestaIncorrecta.pertenece(respuestasIngresadas)).thenReturn(false);
        when(puntajeClasico.calcularPuntaje(1,1,1)).thenReturn(1);

        VoF = new PreguntaVerdaderoOFalso(respuestasIngresadas, puntajeClasico, respuestasPosibles, "Soy una pregunta");
        assertEquals(1,VoF.calcularPuntaje(respuestasIngresadas));
    }

    @Test
    public void test02DadaUnaRespuestaIncorrectaConPuntajeClasicoNoSumaPuntaje(){
        ArrayList<Respuesta> respuestasCorrectas = new ArrayList<>();
        respuestasPosibles = new ArrayList<>();
        respuestasIngresadas = new ArrayList<>();
        PuntajeClasico puntajeClasico =  mock(PuntajeClasico.class);
        Respuesta respuestaIncorrecta = mock(Respuesta.class);
        Respuesta respuestaCorrecta = mock(Respuesta.class);

        respuestasCorrectas.add(respuestaCorrecta);
        respuestasPosibles.add(respuestaCorrecta);
        respuestasPosibles.add(respuestaIncorrecta);
        respuestasIngresadas.add(respuestaIncorrecta);

        when(respuestaIncorrecta.pertenece(respuestasCorrectas)).thenReturn(false);
        VoF = new PreguntaVerdaderoOFalso(respuestasCorrectas, puntajeClasico, respuestasPosibles, "Soy una pregunta");
        assertEquals(VoF.calcularPuntaje(respuestasIngresadas), 0);
    }

    @Test
    public void test03SinRespuestaNoSumaPuntaje(){
        ArrayList<Respuesta> respuestasCorrectas = new ArrayList<>();
        respuestasPosibles = new ArrayList<>();
        respuestasIngresadas = new ArrayList<>();
        PuntajeClasico puntajeClasico =  mock(PuntajeClasico.class);
        Respuesta respuestaIncorrecta = mock(Respuesta.class);
        Respuesta respuestaCorrecta = mock(Respuesta.class);

        respuestasCorrectas.add(respuestaCorrecta);
        respuestasPosibles.add(respuestaCorrecta);
        respuestasPosibles.add(respuestaIncorrecta);


        VoF = new PreguntaVerdaderoOFalso(respuestasCorrectas, puntajeClasico, respuestasPosibles, "Soy una pregunta");
        assertEquals(VoF.calcularPuntaje(respuestasIngresadas), 0);
    }

    @Test
    public void test04DadaUnaRespuestaIncorrectaConPuntajeConPenalizacionEntoncesRestaPuntos(){
        ArrayList<Respuesta> respuestasCorrectas = new ArrayList<>();
        respuestasPosibles = new ArrayList<>();
        respuestasIngresadas = new ArrayList<>();
        PuntajePenalizacion puntajePenalizacion =  mock(PuntajePenalizacion.class);
        Respuesta respuestaIncorrecta = mock(Respuesta.class);
        Respuesta respuestaCorrecta = mock(Respuesta.class);

        respuestasCorrectas.add(respuestaCorrecta);
        respuestasPosibles.add(respuestaCorrecta);
        respuestasPosibles.add(respuestaIncorrecta);
        respuestasIngresadas.add(respuestaIncorrecta);

        when(puntajePenalizacion.calcularPuntaje(0,1,1)).thenReturn(-1);
        when(respuestaIncorrecta.pertenece(respuestasCorrectas)).thenReturn(false);
        VoF = new PreguntaVerdaderoOFalso(respuestasCorrectas, puntajePenalizacion, respuestasPosibles, "Soy una pregunta");
        assertEquals(-1,VoF.calcularPuntaje(respuestasIngresadas));
    }

    @Test
    public void test05UnJugadorEnviaUnaListaDeRespuestasALaPreguntaYRecibePuntosCorrectamente(){
        respuestasIngresadas = new ArrayList<>();
        respuestasPosibles = new ArrayList<>();
        PuntajeClasico puntajeClasico =  mock(PuntajeClasico.class);
        Respuesta respuestaCorrecta = mock(Respuesta.class);
        Respuesta respuestaIncorrecta = mock(Respuesta.class);
        Jugador jugador = mock(Jugador.class);

        respuestasIngresadas.add(respuestaCorrecta);
        respuestasPosibles.add(respuestaCorrecta);
        respuestasPosibles.add(respuestaIncorrecta);

        when(jugador.responderPregunta(respuestasPosibles)).thenReturn(respuestasIngresadas);
        when(jugador.getPuntos()).thenReturn(1);
        when(respuestaCorrecta.pertenece(respuestasIngresadas)).thenReturn(true);
        when(respuestaIncorrecta.pertenece(respuestasIngresadas)).thenReturn(false);
        when(puntajeClasico.calcularPuntaje(1,1,1)).thenReturn(1);

        VoF = new PreguntaVerdaderoOFalso(respuestasIngresadas, puntajeClasico, respuestasPosibles, "Soy una pregunta");
        int puntosObtenidos = VoF.calcularPuntaje(jugador.responderPregunta(respuestasPosibles));
        assertEquals(puntosObtenidos,jugador.getPuntos());

    }
}
