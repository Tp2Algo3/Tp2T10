package MultipleChoice;

import Jugador.Jugador;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import ClasesPreguntas.Puntajes.*;
import ClasesPreguntas.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.ArrayList;

public class PreguntaMultipleChoiceClasicoTest {

    private PreguntaOpcionMultiple multipleChoice;
    ArrayList <Respuesta> respuestasIngresadas;
    PuntajeClasico puntajeClasico;
    PuntajeParcial puntajeParcial;
    PuntajePenalizacion puntajePenalizacion;
    Respuesta respuestaCorrecta;
    PreguntaOpcionMultiple MChoice;
    Respuesta respuestaIncorrecta;
    ArrayList<Respuesta> respuestasPosibles;
    Jugador jugador;


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
        assertEquals(1,MChoice.calcularPuntaje(respuestasIngresadas));
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
        respuestaIncorrecta = new RespuestaIncorrecta ("Soy incorrecta");
        respuestasPosibles.add(respuestaIncorrecta);
        respuestasIngresadas.add(respuestaIncorrecta);

        //Creación de pregunta y assert
        MChoice = new PreguntaOpcionMultiple(puntajeClasico, respuestasPosibles, "Soy una pregunta");
        assertEquals(0, MChoice.calcularPuntaje(respuestasIngresadas));
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
        assertEquals(0, MChoice.calcularPuntaje(respuestasIngresadas));
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
        assertEquals(respuestasIngresadas.size(),MChoice.calcularPuntaje(respuestasIngresadas));
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
        assertEquals(respuestasIngresadas.size(),MChoice.calcularPuntaje(respuestasIngresadas));
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
        assertEquals(0,MChoice.calcularPuntaje(respuestasIngresadas));
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
        assertEquals(-1,MChoice.calcularPuntaje(respuestasIngresadas));
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
        assertEquals(0,MChoice.calcularPuntaje(respuestasIngresadas));
    }

    @Test
    public void test09DadoUnMultipleChoiceConPenalizacionAcertarTotalmenteDaPunto() {
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
        assertEquals(0,MChoice.calcularPuntaje(respuestasIngresadas));
    }

    @Test
    public void test10DadoCualquierPuntajeAsignaSuCorrespondientePuntajeAlJugador(){
        //Inicialización
        respuestasIngresadas = new ArrayList<>();
        respuestasPosibles = new ArrayList<>();
        puntajeClasico = new PuntajeClasico();
        jugador = mock(Jugador.class);

        //Carga de respuestas
        for (int i = 0 ; i < 3 ; i++){
            respuestaCorrecta = new RespuestaCorrecta("Soy correcta");
            respuestasIngresadas.add(respuestaCorrecta);
            respuestasPosibles.add(respuestaCorrecta);
        }

        //Creación de la pregunta
        MChoice = new PreguntaOpcionMultiple(puntajeClasico, respuestasPosibles, "Soy una pregunta");

        //Mock de jugador
        when(jugador.getPuntos()).thenReturn(1);
        jugador.aumentarPuntaje(MChoice.calcularPuntaje(respuestasIngresadas));

        //Assert
        assertEquals(MChoice.calcularPuntaje(respuestasIngresadas), jugador.getPuntos());
    }
}
