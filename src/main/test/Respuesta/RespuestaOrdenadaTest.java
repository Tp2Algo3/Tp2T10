package Respuesta;

import ClasesPreguntas.Respuestas.RespuestaOrdenada;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RespuestaOrdenadaTest {
    RespuestaOrdenada respuestaOrdenada;

    @Test
    public void test01RespuestaBienOrdenadaEsCorrecta() {
        respuestaOrdenada = new RespuestaOrdenada("Soy una opcion.", 0);

        respuestaOrdenada.setPosicionSegunElUsuario(0);

        assertTrue(respuestaOrdenada.esCorrecta());
    }

    @Test
    public void test02RespuestaMalOrdenadaNoEsCorrecta() {
        respuestaOrdenada = new RespuestaOrdenada("Soy una opcion.", 0);

        respuestaOrdenada.setPosicionSegunElUsuario(1);

        assertFalse(respuestaOrdenada.esCorrecta());
    }
}
