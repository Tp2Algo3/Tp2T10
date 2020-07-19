import org.junit.Test;
import org.mockito.InOrder;
import ClasesPreguntas.*;
import java.util.List;

import static org.mockito.Mockito.mock;

public class PreguntaVerdaderoOFalsoTest {
    @Test
    public void DadoUnaRespuestaCorrectaSumarPuntaje(){
        Respuesta respuesta = mock(Respuesta);
        when(respuesta.esCorrecta(new List<Respuesta> lista)).thenReturn(true);
        assertEquals(calcularPuntaje(respuesta), 1);
    }

}
