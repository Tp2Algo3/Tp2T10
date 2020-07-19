import org.junit.Test;
import org.mockito.InOrder;
import ClasesPreguntas.*;
import java.util.List;

import static org.mockito.Mockito.mock;

public class PreguntaVerdaderoOFalsoClasicoTest {

    private Pregunta VoF;
    List <Respuesta> respuestas;

    @BeforeEach
    public void setUp{
        VoF = new PreguntaVerdaderoOFalso();
        respuestas = new List();
    }

    @Test
    public void test01DadoUnaRespuestaCorrectaSumarPuntaje(){
        Respuesta respuesta = mock(Respuesta);
        respuestas.add(respuesta)
        when(respuesta.esCorrecta(respuestas)).thenReturn(true);
        assertEquals(VoF.calcularPuntaje(respuesta), 1);
    }

    @Test
    public void test02DadaUnaRespuestaIncorrectaNoSumaPuntaje{
        Respuesta respuesta = mock(Respuesta);
        respuestas.add(respuesta);
        when(respuesta.esCorrecta(respuestas)).thenReturn(false);
        assertEquals(VoF.calcularPuntaje(respuestas), 0);
    }

    public void test03SinRespuestaNoSumaPuntaje{
        assertEquals(VoF.calcularPuntaje(respuestas), 0)
    }

}
