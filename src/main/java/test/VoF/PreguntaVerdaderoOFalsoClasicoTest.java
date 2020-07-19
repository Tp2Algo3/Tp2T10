package VoF;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import ClasesPreguntas.*;
import org.mockito.InOrder;
import java.util.List;
import static org.mockito.Mockito.mock;

public class PreguntaVerdaderoOFalsoClasicoTest {

    private Pregunta VoF;
    List <Respuesta> respuestas;

    @Test
    public void test01DadoUnaRespuestaCorrectaSumarPuntaje(){
        Respuesta respuesta = mock(Respuesta);
        respuestas.add(respuesta);
        when(respuesta.esCorrecta(respuestas)).thenReturn(true);
        VoF = new PreguntaVerdaderoOFalso(respuestas, new PuntajeClasico(), respuestas, "Soy una pregunta");
        assertEquals(VoF.calcularPuntaje(respuesta), 1);
    }

    @Test
    public void test02DadaUnaRespuestaIncorrectaNoSumaPuntaje(){
        Respuesta respuesta = mock(Respuesta);
        respuestas.add(respuesta);
        when(respuesta.esCorrecta(respuestas)).thenReturn(false);
        VoF = new PreguntaVerdaderoOFalso(respuestas, new PuntajeClasico(), respuestas, "Soy una pregunta");
        assertEquals(VoF.calcularPuntaje(respuestas), 0);
    }

    @Test
    public void test03SinRespuestaNoSumaPuntaje(){
        respuestas.add(new Respuesta("Soy una respuesta)"));
        List<Respuesta> listaVacia;
        VoF = new PreguntaVerdaderoOFalso(respuestas, new PuntajeClasico(), respuestas, "Soy una pregunta");
        assertEquals(VoF.calcularPuntaje(listaVacia), 0);
    }

}
