package VoF;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import ClasesPreguntas.Puntajes.*;
import ClasesPreguntas.*;
import java.util.List;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.ArrayList;

public class PreguntaVerdaderoOFalsoClasicoTest {

    private Pregunta VoF;
    ArrayList <Respuesta> respuestasIngresadas;

    @BeforeEach
    public void setUp(){
        respuestasIngresadas = new ArrayList<Respuesta>();
    }

    @Test
    public void test01DadoUnaRespuestaCorrectaDevolverUnPunto(){
        Respuesta respuestaCorrecta = mock(Respuesta.class);
        PuntajeClasico puntajeClasico =  mock(PuntajeClasico.class);

        respuestasIngresadas.add(respuestaCorrecta);

        when(respuestaCorrecta.pertenece(respuestasIngresadas)).thenReturn(true);
        when(puntajeClasico.calcularPuntaje(1,1)).thenReturn(1);

        VoF = new PreguntaVerdaderoOFalso(respuestasIngresadas, puntajeClasico, respuestasIngresadas, "Soy una pregunta");
        assertEquals(VoF.calcularPuntaje(respuestasIngresadas), 1);
    }

    @Test
    public void test02DadaUnaRespuestaIncorrectaNoSumaPuntaje(){
        Respuesta respuesta = mock(Respuesta.class);
        respuestasIngresadas.add(respuesta);
        when(respuesta.pertenece(respuestasIngresadas)).thenReturn(false);
        VoF = new PreguntaVerdaderoOFalso(respuestasIngresadas, new PuntajeClasico(), respuestasIngresadas, "Soy una pregunta");
        assertEquals(VoF.calcularPuntaje(respuestasIngresadas), 0);
    }

    @Test
    public void test03SinRespuestaNoSumaPuntaje(){
        respuestasIngresadas.add(new Respuesta("Soy una respuesta)"));
        List<Respuesta> listaVacia = new ArrayList();
        VoF = new PreguntaVerdaderoOFalso(respuestasIngresadas, new PuntajeClasico(), respuestasIngresadas, "Soy una pregunta");
        assertEquals(VoF.calcularPuntaje(listaVacia), 0);
    }

}
