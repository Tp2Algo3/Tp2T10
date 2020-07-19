package MultipleChoice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import ClasesPreguntas.Puntajes.*;
import ClasesPreguntas.*;
import java.util.List;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.ArrayList;

public class PreguntaMultipleChoiceClasicoTest {
    private PreguntaOpcionMultiple multipleChoice;
    ArrayList <Respuesta> respuestasIngresadas;

    @BeforeEach
    public void setUp(){
        respuestasIngresadas = new ArrayList<Respuesta>();
    }

    @Test
    public void test01AcertarCompletamenteUnMultipleChoiceTeDaElPunto(){
        ArrayList<Respuesta> respuestasCorrectas = new ArrayList<Respuesta>();
        PuntajeClasico puntajeClasico = mock(PuntajeClasico.class);

        for (int i = 0 ; i < 3 ; i++){
            Respuesta respuestaCorrecta = mock(Respuesta.class);
            respuestasCorrectas.add(respuestaCorrecta);
            respuestasIngresadas.add(respuestaCorrecta);
        }

        for (Respuesta respuestaIngresada: respuestasIngresadas) {
            when(respuestaIngresada.pertenece(respuestasCorrectas)).thenReturn(true);
        }


        when(puntajeClasico.calcularPuntaje(3,3,3)).thenReturn(1);

        Pregunta MC = new PreguntaOpcionMultiple(respuestasCorrectas, puntajeClasico, respuestasCorrectas, "Soy una pregunta");
        assertEquals(MC.calcularPuntaje(respuestasIngresadas), 1);
    }
    
    @Test
    public void test02AcertarParcialmenteUnMultipleChoiceNoTeDaPunto(){
        ArrayList<Respuesta> respuestasCorrectas = new ArrayList<Respuesta>();
        PuntajeClasico puntajeClasico = mock(PuntajeClasico.class);

        for (int i = 0 ; i < 3 ; i++){
            Respuesta respuestaCorrecta = mock(Respuesta.class);
            respuestasCorrectas.add(respuestaCorrecta);
            respuestasIngresadas.add(respuestaCorrecta);
        }

        for (Respuesta respuestaIngresada: respuestasIngresadas) {
            when(respuestaIngresada.pertenece(respuestasCorrectas)).thenReturn(true);
        }
        when(respuestasIngresadas.get(1).pertenece(respuestasCorrectas)).thenReturn(false);
        when(puntajeClasico.calcularPuntaje(2,3,3)).thenReturn(0);

        Pregunta MC = new PreguntaOpcionMultiple(respuestasCorrectas, puntajeClasico, respuestasCorrectas, "Soy una pregunta");    
        assertEquals(MC.calcularPuntaje(respuestasIngresadas), 0);

    }
}
