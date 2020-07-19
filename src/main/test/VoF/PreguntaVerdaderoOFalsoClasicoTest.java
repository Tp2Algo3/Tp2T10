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
    ArrayList <Respuesta> respuestas;

    @BeforeEach
    public void setUp(){
        respuestas = new ArrayList<Respuesta>();
    }

    @Test
    public void test01DadoUnaRespuestaCorrectaSumarPuntaje(){
        Respuesta respuesta = mock(Respuesta.class);
        respuestas.add(respuesta);
        when(respuesta.esCorrecta(respuestas)).thenReturn(true);
        VoF = new PreguntaVerdaderoOFalso(respuestas, new PuntajeClasico(), respuestas, "Soy una pregunta");
        assertEquals(VoF.calcularPuntaje(respuestas), 1);
    }

    @Test
    public void test02DadaUnaRespuestaIncorrectaNoSumaPuntaje(){
        Respuesta respuesta = mock(Respuesta.class);
        respuestas.add(respuesta);
        when(respuesta.esCorrecta(respuestas)).thenReturn(false);
        VoF = new PreguntaVerdaderoOFalso(respuestas, new PuntajeClasico(), respuestas, "Soy una pregunta");
        assertEquals(VoF.calcularPuntaje(respuestas), 0);
    }

    @Test
    public void test03SinRespuestaNoSumaPuntaje(){
        respuestas.add(new Respuesta("Soy una respuesta)"));
        List<Respuesta> listaVacia = new ArrayList();
        VoF = new PreguntaVerdaderoOFalso(respuestas, new PuntajeClasico(), respuestas, "Soy una pregunta");
        assertEquals(VoF.calcularPuntaje(listaVacia), 0);
    }

}
