package Respuesta;

import ClasesPreguntas.Respuestas.RespuestaGroup;
import org.junit.jupiter.api.Test;

public class RespuestaGroupTest {
    private RespuestaGroup respuesta;

    @Test
    public void test00DadaUnaRespuestaMalElegidaDevuelveNoEsCorrecta(){
        respuesta = new RespuestaGroup("Soy UnaRespuesta",1);

        assert(!respuesta.esCorrecta());
    }

    @Test
    public void test01DadaUnaRespuestaBienElegidaDevuelveEsCorrecta(){
        respuesta = new RespuestaGroup("Soy UnaRespuesta",1);
        respuesta.cambiarGrupo();
        assert(respuesta.esCorrecta());
    }
}
