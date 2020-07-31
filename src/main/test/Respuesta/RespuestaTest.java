package Respuesta;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import ClasesPreguntas.*;

public class RespuestaTest {

    Respuesta respuesta;

    @Test
    public void test01RespuestaCorrectaMeDevuelveQueEsCorrecta(){
        respuesta = new RespuestaCorrecta("Soy correcta");
        assertEquals(true,respuesta.esCorrecta());
    }


    @Test
    public void test02RespuestaIncorrectaMeDevuelveQueEsIncorrecta(){
        respuesta = new RespuestaIncorrecta("Soy incorrecta");
        assertEquals(false,respuesta.esCorrecta());
    }
}
