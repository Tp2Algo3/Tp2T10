package MultipleChoice;

import Preguntas.PreguntaOpcionMultiple;
import Respuestas.Respuesta;
import Respuestas.RespuestaCorrecta;
import Respuestas.RespuestaIncorrecta;
import Jugador.Jugador;
import Puntajes.PuntajeClasico;
import Puntajes.PuntajeParcial;
import Puntajes.PuntajePenalizacion;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.mock;

import java.util.ArrayList;

public class PreguntaMultipleChoiceTest {

    ArrayList <Respuesta> respuestasIngresadas;
    ArrayList <Respuesta> respuestasJ1;
    ArrayList <Respuesta> respuestasJ2;
    PuntajeClasico puntajeClasico;
    PuntajeParcial puntajeParcial;
    PuntajePenalizacion puntajePenalizacion;
    Respuesta respuestaCorrecta;
    PreguntaOpcionMultiple MChoice;
    Respuesta respuestaIncorrecta;
    ArrayList<Respuesta> respuestasPosibles;
    Jugador jugador;
    Jugador jugador2;
    ArrayList<Integer> puntajes;


    @Test
    public void test01AcertarCompletamenteUnMultipleChoiceClasicoTeDaElPunto(){
        //Inicialización
        respuestasIngresadas = new ArrayList<>();
        respuestasPosibles = new ArrayList<>();
        puntajeClasico = new PuntajeClasico();

        //Carga de respuestas
        for (int i = 0 ; i < 3 ; i++){
            respuestaCorrecta = new RespuestaCorrecta("Soy correcta");
            respuestasIngresadas.add(respuestaCorrecta);
            respuestasPosibles.add(respuestaCorrecta);
        }

        //Creación de la pregunta y assert
        MChoice = new PreguntaOpcionMultiple(puntajeClasico, respuestasPosibles, "Soy una pregunta");
        MChoice.calcularPuntajeIndividual(respuestasIngresadas);
        puntajes = MChoice.definirPuntajesDeJugadores();
        assertEquals(1,puntajes.get(0));
    }

    @Test
    public void test02AcertarParcialmenteUnMultipleChoiceClasicoNoTeDaPunto(){
        //Inicialización
        respuestasIngresadas = new ArrayList<>();
        respuestasPosibles = new ArrayList<>();
        puntajeClasico = new PuntajeClasico();

        //Carga de respuestas
        for (int i = 0 ; i < 3 ; i++){
            respuestaCorrecta = new RespuestaCorrecta("Soy correcta");
            respuestasIngresadas.add(respuestaCorrecta);
            respuestasPosibles.add(respuestaCorrecta);
        }
        respuestaIncorrecta = new RespuestaIncorrecta("Soy incorrecta");
        respuestasPosibles.add(respuestaIncorrecta);
        respuestasIngresadas.add(respuestaIncorrecta);

        //Creación de pregunta y assert
        MChoice = new PreguntaOpcionMultiple(puntajeClasico, respuestasPosibles, "Soy una pregunta");
        MChoice.calcularPuntajeIndividual(respuestasIngresadas);
        puntajes = MChoice.definirPuntajesDeJugadores();
        assertEquals(0,puntajes.get(0));
    }

    @Test
    public void test03DadoUnMultipleChoiceClasicoResponderAlgunasRespuestasCorrectasSinQueSeanTodasNoDaPunto(){
        //Inicialización
        respuestasIngresadas = new ArrayList<>();
        respuestasPosibles = new ArrayList<>();
        puntajeClasico = new PuntajeClasico();

        //Carga de respuestas
        for (int i = 0 ; i < 3 ; i++){
            respuestaCorrecta = new RespuestaCorrecta("Soy correcta");
            respuestasIngresadas.add(respuestaCorrecta);
            respuestasPosibles.add(respuestaCorrecta);
        }
        respuestasIngresadas.remove(2);

        //Creación de pregunta y assert
        MChoice = new PreguntaOpcionMultiple(puntajeClasico, respuestasPosibles, "Soy una pregunta");
        MChoice.calcularPuntajeIndividual(respuestasIngresadas);
        puntajes = MChoice.definirPuntajesDeJugadores();
        assertEquals(0,puntajes.get(0));
    }

    @Test
    public void test04AcertarCompletamenteUnMultipleChoiceParcialTeDaLosPuntosCorrespondientes(){
        //Inicialización
        respuestasIngresadas = new ArrayList<>();
        respuestasPosibles = new ArrayList<>();
        puntajeParcial = new PuntajeParcial();

        //Carga de respuestas
        for (int i = 0 ; i < 3 ; i++){
            respuestaCorrecta = new RespuestaCorrecta("Soy correcta");
            respuestasIngresadas.add(respuestaCorrecta);
            respuestasPosibles.add(respuestaCorrecta);
        }

        //Creación de la pregunta y assert
        MChoice = new PreguntaOpcionMultiple(puntajeParcial, respuestasPosibles, "Soy una pregunta");
        MChoice.calcularPuntajeIndividual(respuestasIngresadas);
        puntajes = MChoice.definirPuntajesDeJugadores();
        assertEquals(respuestasIngresadas.size(),puntajes.get(0));
    }

    @Test
    public void test05AcertarParcialmenteUnMultipleChoiceParcialTeDaLosPuntosCorrespondientes(){
        //Inicialización
        respuestasIngresadas = new ArrayList<>();
        respuestasPosibles = new ArrayList<>();
        puntajeParcial = new PuntajeParcial();

        //Carga de respuestas
        for (int i = 0 ; i < 2 ; i++){
            respuestaCorrecta = new RespuestaCorrecta("Soy correcta");
            respuestasIngresadas.add(respuestaCorrecta);
            respuestasPosibles.add(respuestaCorrecta);
        }
        respuestasPosibles.add(respuestaCorrecta);

        //Creación de la pregunta y assert
        MChoice = new PreguntaOpcionMultiple(puntajeParcial, respuestasPosibles, "Soy una pregunta");
        MChoice.calcularPuntajeIndividual(respuestasIngresadas);
        puntajes = MChoice.definirPuntajesDeJugadores();
        assertEquals(respuestasIngresadas.size(),puntajes.get(0));
    }

    @Test
    public void test06DadoUnMultipleChoiceParcialErrarEnAlgunaRespuestaNoSumaPuntos(){
        //Inicialización
        respuestasIngresadas = new ArrayList<>();
        respuestasPosibles = new ArrayList<>();
        puntajeParcial = new PuntajeParcial();

        //Carga de respuestas
        respuestaCorrecta = new RespuestaCorrecta("Soy Correcta");
        respuestasPosibles.add(respuestaCorrecta);
        respuestaIncorrecta = new RespuestaIncorrecta ("Soy Incorrecta");
        respuestasPosibles.add(respuestaIncorrecta);
        respuestasIngresadas.add(respuestaIncorrecta);

        //Creación de la pregunta y assert
        MChoice = new PreguntaOpcionMultiple(puntajeParcial, respuestasPosibles, "Soy una pregunta");
        MChoice.calcularPuntajeIndividual(respuestasIngresadas);
        puntajes = MChoice.definirPuntajesDeJugadores();
        assertEquals(0,puntajes.get(0));
    }

    @Test
    public void test07DadoUnMultipleChoiceConPenalizacionErrarUnaRespuestaResta1Punto(){
        //Inicialización
        respuestasIngresadas = new ArrayList<>();
        respuestasPosibles = new ArrayList<>();
        puntajePenalizacion = new PuntajePenalizacion();

        //Carga de respuestas
        respuestaCorrecta = new RespuestaCorrecta("Soy Correcta");
        respuestasPosibles.add(respuestaCorrecta);
        respuestaIncorrecta = new RespuestaIncorrecta ("Soy Incorrecta");
        respuestasPosibles.add(respuestaIncorrecta);
        respuestasIngresadas.add(respuestaIncorrecta);

        //Creación de la pregunta y assert
        MChoice = new PreguntaOpcionMultiple(puntajePenalizacion, respuestasPosibles, "Soy una pregunta");
        MChoice.calcularPuntajeIndividual(respuestasIngresadas);
        puntajes = MChoice.definirPuntajesDeJugadores();
        assertEquals(-1,puntajes.get(0));
    }

    @Test
    public void test08DadoUnMultipleChoiceConPenalizacionAcertarParcialmenteNoDaPunto() {
        //Inicialización
        respuestasIngresadas = new ArrayList<>();
        respuestasPosibles = new ArrayList<>();
        puntajePenalizacion = new PuntajePenalizacion();

        //Carga de respuestas
        for (int i=0; i<3; i++){
            respuestaCorrecta = new RespuestaCorrecta("Soy Correcta");
            respuestasIngresadas.add(respuestaCorrecta);
            respuestasPosibles.add(respuestaCorrecta);
        }
        respuestasIngresadas.remove(2);

        //Creación de la pregunta y assert
        MChoice = new PreguntaOpcionMultiple(puntajePenalizacion, respuestasPosibles, "Soy una pregunta");
        MChoice.calcularPuntajeIndividual(respuestasIngresadas);
        puntajes = MChoice.definirPuntajesDeJugadores();
        assertEquals(0,puntajes.get(0));
    }


    @Test
    public void test09DadoCualquierPuntajeAsignaSuCorrespondientePuntajeAlJugador(){
        //Inicialización
        respuestasIngresadas = new ArrayList<>();
        respuestasPosibles = new ArrayList<>();
        puntajeClasico = new PuntajeClasico();
        jugador = new Jugador("nombre");

        //Carga de respuestas
        for (int i = 0 ; i < 3 ; i++){
            respuestaCorrecta = new RespuestaCorrecta("Soy correcta");
            respuestasIngresadas.add(respuestaCorrecta);
            respuestasPosibles.add(respuestaCorrecta);
        }

        //Creación de la pregunta y suma al jugador
        MChoice = new PreguntaOpcionMultiple(puntajeClasico, respuestasPosibles, "Soy una pregunta");
        MChoice.calcularPuntajeIndividual(respuestasIngresadas);
        puntajes = MChoice.definirPuntajesDeJugadores();
        jugador.aumentarPuntaje(puntajes.get(0));

        //Assert
        assertEquals(puntajes.get(0), jugador.getPuntos());
    }

    @Test
    public void test10DadaLaActivacionDeUnaExclusividadYDosJugadoresQueContestanBienNingunoSumaPuntos(){
        //Inicialización
        jugador = new Jugador("Juan");
        respuestasJ1 = new ArrayList<>();
        respuestasJ2 = new ArrayList<>();
        respuestasPosibles = new ArrayList<>();

        //Genero las respuestas de la pregunta y de los jugadores
        for (int i=0; i<2; i++) {
            respuestaCorrecta = new RespuestaCorrecta("Soy una respuesta");
            respuestasPosibles.add(respuestaCorrecta);
            respuestasJ1.add(respuestaCorrecta);
            respuestasJ2.add(respuestaCorrecta);
        }

        //Creo el Multiple Choice
        MChoice = new PreguntaOpcionMultiple(new PuntajeClasico(),respuestasPosibles,"Que te pregunto?");
        //Activo Exclusividad
        jugador.utilizarExclusividad(MChoice);

        //Calculo de Puntajes
        MChoice.calcularPuntajeIndividual(respuestasJ1);
        MChoice.calcularPuntajeIndividual(respuestasJ2);
        puntajes = MChoice.definirPuntajesDeJugadores();

        //Assert
        assertEquals(0,puntajes.get(0));
        assertEquals(0,puntajes.get(0));
    }

    @Test
    public void test11DadaLaActivacionDeUnaExclusividadYUnSoloJugadorContestaBienSoloEsteMultiplicaPuntos(){
        //Inicialización
        jugador = new Jugador("Juan");
        jugador2 = new Jugador("Pepito");
        respuestasJ1 = new ArrayList<>();
        respuestasJ2 = new ArrayList<>();
        respuestasPosibles = new ArrayList<>();

        //Genero las respuestas de la pregunta y de los jugadores
        for (int i=0; i<2; i++) {
            respuestaCorrecta = new RespuestaCorrecta("Soy una respuesta");
            respuestasPosibles.add(respuestaCorrecta);
            respuestasJ1.add(respuestaCorrecta);
            respuestasJ2.add(respuestaCorrecta);
        }
        respuestaIncorrecta = new RespuestaIncorrecta("Soy incorrecta");
        respuestasPosibles.add(respuestaIncorrecta);
        respuestasJ2.add(respuestaIncorrecta);

        //Creo el Multiple Choice
        MChoice = new PreguntaOpcionMultiple(new PuntajeClasico(),respuestasPosibles,"Que te pregunto?");
        //Activo Exclusividad
        jugador.utilizarExclusividad(MChoice);
        jugador2.utilizarExclusividad(MChoice);

        //Calculo de Puntajes
        MChoice.calcularPuntajeIndividual(respuestasJ1);
        MChoice.calcularPuntajeIndividual(respuestasJ2);
        puntajes = MChoice.definirPuntajesDeJugadores();

        //Assert
        assertEquals(4,puntajes.get(0));
        assertEquals(0,puntajes.get(1));
    }

    @Test
    public void test12DadaLaActivacionDosExclusividadesYUnSoloJugadorContestaBienSoloEsteMultiplicaPuntos(){
        //Inicialización
        jugador = new Jugador("Juan");
        respuestasJ1 = new ArrayList<>();
        respuestasJ2 = new ArrayList<>();
        respuestasPosibles = new ArrayList<>();

        //Genero las respuestas de la pregunta y de los jugadores
        for (int i=0; i<2; i++) {
            respuestaCorrecta = new RespuestaCorrecta("Soy una respuesta");
            respuestasPosibles.add(respuestaCorrecta);
            respuestasJ1.add(respuestaCorrecta);
            respuestasJ2.add(respuestaCorrecta);
        }
        respuestaIncorrecta = new RespuestaIncorrecta("Soy incorrecta");
        respuestasPosibles.add(respuestaIncorrecta);
        respuestasJ2.add(respuestaIncorrecta);

        //Creo el Multiple Choice
        MChoice = new PreguntaOpcionMultiple(new PuntajeClasico(),respuestasPosibles,"Que te pregunto?");
        //Activo Exclusividad
        jugador.utilizarExclusividad(MChoice);

        //Calculo de Puntajes
        MChoice.calcularPuntajeIndividual(respuestasJ1);
        MChoice.calcularPuntajeIndividual(respuestasJ2);
        puntajes = MChoice.definirPuntajesDeJugadores();

        //Assert
        assertEquals(2,puntajes.get(0));
        assertEquals(0,puntajes.get(1));
    }
}
