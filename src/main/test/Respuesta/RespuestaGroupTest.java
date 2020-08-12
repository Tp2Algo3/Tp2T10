package Respuesta;

import Modelo.Respuestas.RespuestaGroup;
import Modelo.Grupo.Grupo;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RespuestaGroupTest {

    private Grupo grupo1;
    private RespuestaGroup respuesta;

    @Test
    public void test01DadaUnaRespuestaSinElegirDevuelveNoEsCorrecta(){
        grupo1 = new Grupo("Soy grupo n1", new ArrayList<>());
        respuesta = new RespuestaGroup("Soy UnaRespuesta");

        assertFalse(respuesta.esCorrecta());
    }

    @Test
    public void test02DadaUnaRespuestaBienElegidaDevuelveEsCorrecta(){
        grupo1 = new Grupo("Soy grupo n1", new ArrayList<>());
        respuesta = new RespuestaGroup("Soy UnaRespuesta");
        grupo1.aniadirRespuesta(respuesta);
        respuesta.cambiarGrupo(grupo1);
        assertTrue(respuesta.esCorrecta());
    }

    @Test
    public void test03DadaUnaRespuestaMalElegidaDevuelveNoEsCorrecta(){
        grupo1 = new Grupo("Soy grupo n1", new ArrayList<>());
        respuesta = new RespuestaGroup("Soy UnaRespuesta");
        respuesta.cambiarGrupo(grupo1);
        assertFalse(respuesta.esCorrecta());
    }
}
