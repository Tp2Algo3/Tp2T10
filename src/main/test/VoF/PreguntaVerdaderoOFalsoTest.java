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
    Respuesta respuestaCorrecta;
    Respuesta respuestaIncorrecta;
    Jugador jugador;
    PuntajePenalizacion puntajePenalizacion;


    @Test
    public void test01DadoUnaRespuestaCorrectaDevolverUnPunto(){
        //Inicialización
        respuestasIngresadas = new ArrayList<>();
        respuestasPosibles = new ArrayList<>();
        puntajeClasico =  new PuntajeClasico();
        respuestaCorrecta = new RespuestaCorrecta("Soy Correcta");
        respuestaIncorrecta = new RespuestaIncorrecta("Soy incorrecta");

        //Carga de respuestas
        respuestasIngresadas.add(respuestaCorrecta);
        respuestasPosibles.add(respuestaCorrecta);
        respuestasPosibles.add(respuestaIncorrecta);

        //Creación de la pregunta y assert
        VoF = new PreguntaVerdaderoOFalso(puntajeClasico, respuestasPosibles, "Soy una pregunta");
        assertEquals(1,VoF.calcularPuntaje(respuestasIngresadas));
    }

    @Test
    public void test02DadaUnaRespuestaIncorrectaConPuntajeClasicoNoSumaPuntaje(){
        //Inicialización
        respuestasPosibles = new ArrayList<>();
        respuestasIngresadas = new ArrayList<>();
        puntajeClasico =  new PuntajeClasico();
        respuestaIncorrecta = new RespuestaIncorrecta("Soy incorrecta");
        respuestaCorrecta = new RespuestaCorrecta("Soy correcta");

        //Carga de respuestas
        respuestasPosibles.add(respuestaCorrecta);
        respuestasPosibles.add(respuestaIncorrecta);
        respuestasIngresadas.add(respuestaIncorrecta);

        //Creación de pregunta y assert
        VoF = new PreguntaVerdaderoOFalso(puntajeClasico, respuestasPosibles, "Soy una pregunta");
        assertEquals(0, VoF.calcularPuntaje(respuestasIngresadas));
    }

    @Test
    public void test03SinRespuestaNoSumaPuntaje(){
        //Inicialización
        respuestasPosibles = new ArrayList<>();
        respuestasIngresadas = new ArrayList<>();
        puntajeClasico =  new PuntajeClasico();
        respuestaIncorrecta = new RespuestaIncorrecta ("Soy incorrecta");
        respuestaCorrecta = new RespuestaCorrecta ("Soy correcta");

        //Carga de respuestas
        respuestasPosibles.add(respuestaCorrecta);
        respuestasPosibles.add(respuestaIncorrecta);

        //Creación de pregunta y assert
        VoF = new PreguntaVerdaderoOFalso(puntajeClasico, respuestasPosibles, "Soy una pregunta");
        assertEquals(VoF.calcularPuntaje(respuestasIngresadas), 0);
    }

    @Test
    public void test04DadaUnaRespuestaIncorrectaConPuntajeConPenalizacionEntoncesRestaPuntos(){
        //Inicialización
        respuestasPosibles = new ArrayList<>();
        respuestasIngresadas = new ArrayList<>();
        puntajePenalizacion =  new PuntajePenalizacion();
        respuestaIncorrecta = new RespuestaIncorrecta ("Soy incorrecta");
        respuestaCorrecta = new RespuestaCorrecta ("Soy correcta");

        //Carga de respuestas
        respuestasPosibles.add(respuestaCorrecta);
        respuestasPosibles.add(respuestaIncorrecta);
        respuestasIngresadas.add(respuestaIncorrecta);

        //Creación de pregunta y assert
        VoF = new PreguntaVerdaderoOFalso(puntajePenalizacion, respuestasPosibles, "Soy una pregunta");
        assertEquals(-1,VoF.calcularPuntaje(respuestasIngresadas));
    }

    @Test
    public void test05UnJugadorEnviaUnaListaDeRespuestasALaPreguntaYRecibePuntosCorrectamente(){
        respuestasIngresadas = new ArrayList<>();
        respuestasPosibles = new ArrayList<>();
        puntajeClasico =  new PuntajeClasico();
        respuestaCorrecta = new RespuestaCorrecta ("Soy Correcta");
        respuestaIncorrecta = new RespuestaIncorrecta ("Soy Incorrecta");
        jugador = mock(Jugador.class);

        respuestasIngresadas.add(respuestaCorrecta);
        respuestasPosibles.add(respuestaCorrecta);
        respuestasPosibles.add(respuestaIncorrecta);

        //Mock al jugador
        when(jugador.responderPregunta(respuestasPosibles)).thenReturn(respuestasIngresadas);
        when(jugador.getPuntos()).thenReturn(1);

        //Creacion de pregunta y assert
        VoF = new PreguntaVerdaderoOFalso(puntajeClasico, respuestasPosibles, "Soy una pregunta");
        assertEquals(VoF.calcularPuntaje(jugador.responderPregunta(respuestasPosibles)),jugador.getPuntos());
    }
}
