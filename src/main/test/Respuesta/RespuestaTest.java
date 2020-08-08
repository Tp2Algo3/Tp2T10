package Respuesta;

import Respuestas.Respuesta;
import Respuestas.RespuestaCorrecta;
import Respuestas.RespuestaIncorrecta;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RespuestaTest {

    Respuesta respuesta;

    @Test
    public void test01RespuestaCorrectaMeDevuelveQueEsCorrecta(){
        respuesta = new RespuestaCorrecta("Soy correcta");
        assertTrue(respuesta.esCorrecta());
    }


    @Test
    public void test02RespuestaIncorrectaMeDevuelveQueEsIncorrecta(){
        respuesta = new RespuestaIncorrecta("Soy incorrecta");
        assertFalse(respuesta.esCorrecta());
    }
}
