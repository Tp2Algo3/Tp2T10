package VoF;

import Preguntas.Pregunta;
import Preguntas.PreguntaVerdaderoOFalso;
import Respuestas.Respuesta;
import Respuestas.RespuestaCorrecta;
import Respuestas.RespuestaIncorrecta;
import Puntajes.PuntajeClasico;
import Puntajes.PuntajePenalizacion;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.mock;

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
    Jugador jugador2;
    PuntajePenalizacion puntajePenalizacion;
    ArrayList<Integer> puntajes;
    ArrayList<ArrayList<Respuesta>> respuestasJugadores;


    @Test
    public void test01DadoUnaRespuestaCorrectaDevolverUnPunto(){
        //Inicialización
        respuestasIngresadas = new ArrayList<>();
        respuestasPosibles = new ArrayList<>();
        puntajeClasico =  new PuntajeClasico();
        respuestaCorrecta = new RespuestaCorrecta("Soy Correcta");
        respuestaIncorrecta = new RespuestaIncorrecta("Soy incorrecta");
        respuestasJugadores = new ArrayList<>();

        //Carga de respuestas
        respuestasIngresadas.add(respuestaCorrecta);
        respuestasPosibles.add(respuestaCorrecta);
        respuestasPosibles.add(respuestaIncorrecta);

        //Creación de la pregunta y assert
        VoF = new PreguntaVerdaderoOFalso(puntajeClasico, respuestasPosibles, "Soy una pregunta");
        respuestasJugadores.add(respuestasIngresadas);
        puntajes = VoF.definirPuntajesDeJugadores(respuestasJugadores);
        assertEquals(1,puntajes.get(0));
    }

    @Test
    public void test02DadaUnaRespuestaIncorrectaConPuntajeClasicoNoSumaPuntaje(){
        //Inicialización
        respuestasPosibles = new ArrayList<>();
        respuestasIngresadas = new ArrayList<>();
        puntajeClasico =  new PuntajeClasico();
        respuestaIncorrecta = new RespuestaIncorrecta("Soy incorrecta");
        respuestaCorrecta = new RespuestaCorrecta("Soy correcta");
        respuestasJugadores = new ArrayList<>();

        //Carga de respuestas
        respuestasPosibles.add(respuestaCorrecta);
        respuestasPosibles.add(respuestaIncorrecta);
        respuestasIngresadas.add(respuestaIncorrecta);

        //Creación de pregunta y assert
        VoF = new PreguntaVerdaderoOFalso(puntajeClasico, respuestasPosibles, "Soy una pregunta");
        respuestasJugadores.add(respuestasIngresadas);
        puntajes = VoF.definirPuntajesDeJugadores(respuestasJugadores);
        assertEquals(0,puntajes.get(0));
    }

    @Test
    public void test03SinRespuestaNoSumaPuntaje(){
        //Inicialización
        respuestasPosibles = new ArrayList<>();
        respuestasIngresadas = new ArrayList<>();
        puntajeClasico =  new PuntajeClasico();
        respuestaIncorrecta = new RespuestaIncorrecta ("Soy incorrecta");
        respuestaCorrecta = new RespuestaCorrecta ("Soy correcta");
        respuestasJugadores = new ArrayList<>();

        //Carga de respuestas
        respuestasPosibles.add(respuestaCorrecta);
        respuestasPosibles.add(respuestaIncorrecta);

        //Creación de pregunta y assert
        VoF = new PreguntaVerdaderoOFalso(puntajeClasico, respuestasPosibles, "Soy una pregunta");
        respuestasJugadores.add(respuestasIngresadas);
        puntajes = VoF.definirPuntajesDeJugadores(respuestasJugadores);
        assertEquals(0,puntajes.get(0));
    }

    @Test
    public void test04DadaUnaRespuestaIncorrectaConPuntajeConPenalizacionEntoncesRestaPuntos(){
        //Inicialización
        respuestasPosibles = new ArrayList<>();
        respuestasIngresadas = new ArrayList<>();
        puntajePenalizacion =  new PuntajePenalizacion();
        respuestaIncorrecta = new RespuestaIncorrecta ("Soy incorrecta");
        respuestaCorrecta = new RespuestaCorrecta ("Soy correcta");
        respuestasJugadores = new ArrayList<>();

        //Carga de respuestas
        respuestasPosibles.add(respuestaCorrecta);
        respuestasPosibles.add(respuestaIncorrecta);
        respuestasIngresadas.add(respuestaIncorrecta);

        //Creación de pregunta y assert
        VoF = new PreguntaVerdaderoOFalso(puntajePenalizacion, respuestasPosibles, "Soy una pregunta");
        respuestasJugadores.add(respuestasIngresadas);
        puntajes = VoF.definirPuntajesDeJugadores(respuestasJugadores);
        assertEquals(-1,puntajes.get(0));
    }

    @Test
    public void test05UnJugadorEnviaUnaListaDeRespuestasALaPreguntaYRecibePuntosCorrectamente(){
        respuestasIngresadas = new ArrayList<>();
        respuestasPosibles = new ArrayList<>();
        puntajeClasico =  new PuntajeClasico();
        respuestaCorrecta = new RespuestaCorrecta ("Soy Correcta");
        respuestaIncorrecta = new RespuestaIncorrecta ("Soy Incorrecta");
        jugador = new Jugador("Heliodoro");
        respuestasJugadores = new ArrayList<>();

        respuestasIngresadas.add(respuestaCorrecta);
        respuestasPosibles.add(respuestaCorrecta);
        respuestasPosibles.add(respuestaIncorrecta);


        //Creacion de pregunta y assert
        VoF = new PreguntaVerdaderoOFalso(puntajeClasico, respuestasPosibles, "Soy una pregunta");
        respuestasJugadores.add(respuestasIngresadas);
        puntajes = VoF.definirPuntajesDeJugadores(respuestasJugadores);
        jugador.aumentarPuntaje(puntajes.get(0));
        assertEquals(puntajes.get(0),jugador.getPuntos());
    }

    @Test
    public void test06DadaLaActivacionDeUnaExclusividadYAmbosJugadoresRespondenCorrectamenteNoSumanPuntos(){
        jugador = new Jugador("Pedro");
        jugador2 = new Jugador("Jacinto");
        respuestasPosibles = new ArrayList<>();
        respuestaCorrecta = new RespuestaCorrecta("Correctooo");
        respuestaIncorrecta = new RespuestaIncorrecta("Incorrectisimo");
        respuestasJugadores = new ArrayList<>();

        jugador.aniadirRespuesta(respuestaCorrecta);
        jugador2.aniadirRespuesta(respuestaCorrecta);
        respuestasPosibles.add(respuestaCorrecta);
        respuestasPosibles.add(respuestaIncorrecta);

        VoF = new PreguntaVerdaderoOFalso(new PuntajeClasico(),respuestasPosibles, "Soy un VOF");
        jugador.utilizarExclusividad(VoF);

        respuestasJugadores.add(jugador.responderPregunta());
        respuestasJugadores.add(jugador2.responderPregunta());
        puntajes = VoF.definirPuntajesDeJugadores(respuestasJugadores);

        assertEquals(0,puntajes.get(0));
        assertEquals(0,puntajes.get(1));
    }

    @Test
    public void test07DadaLaActivacionDeUnaExclusividadYUnSoloJugadorRespondeBienEsteMultiplicaSusPuntos(){
        jugador = new Jugador("Pedro");
        jugador2 = new Jugador("Jacinto");
        respuestasPosibles = new ArrayList<>();
        respuestaCorrecta = new RespuestaCorrecta("Correctooo");
        respuestaIncorrecta = new RespuestaIncorrecta("Incorrectisimo");
        respuestasJugadores = new ArrayList<>();

        jugador.aniadirRespuesta(respuestaCorrecta);
        jugador2.aniadirRespuesta(respuestaIncorrecta);
        respuestasPosibles.add(respuestaCorrecta);
        respuestasPosibles.add(respuestaIncorrecta);

        VoF = new PreguntaVerdaderoOFalso(new PuntajeClasico(),respuestasPosibles, "Soy un VOF");
        jugador.utilizarExclusividad(VoF);

        respuestasJugadores.add(jugador.responderPregunta());
        respuestasJugadores.add(jugador2.responderPregunta());
        puntajes = VoF.definirPuntajesDeJugadores(respuestasJugadores);

        assertEquals(2,puntajes.get(0));
        assertEquals(0,puntajes.get(1));
    }

    @Test
    public void test08DadaLaActivacionDeDosExclusividadesYUnSoloJugadorRespondeBienEsteMultiplicaSusPuntosDosVeces(){
        jugador = new Jugador("Pedro");
        jugador2 = new Jugador("Jacinto");
        respuestasPosibles = new ArrayList<>();
        respuestaCorrecta = new RespuestaCorrecta("Correctooo");
        respuestaIncorrecta = new RespuestaIncorrecta("Incorrectisimo");
        respuestasJugadores = new ArrayList<>();

        jugador.aniadirRespuesta(respuestaCorrecta);
        jugador2.aniadirRespuesta(respuestaIncorrecta);
        respuestasPosibles.add(respuestaCorrecta);
        respuestasPosibles.add(respuestaIncorrecta);

        VoF = new PreguntaVerdaderoOFalso(new PuntajeClasico(),respuestasPosibles, "Soy un VOF");
        jugador.utilizarExclusividad(VoF);
        jugador2.utilizarExclusividad(VoF);

        respuestasJugadores.add(jugador.responderPregunta());
        respuestasJugadores.add(jugador2.responderPregunta());
        puntajes = VoF.definirPuntajesDeJugadores(respuestasJugadores);

        assertEquals(4,puntajes.get(0));
        assertEquals(0,puntajes.get(1));
    }


}
