package GrupoTest;

import Modelo.Grupo.Grupo;
import Modelo.Respuestas.RespuestaGroup;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GrupoTest {

    private ArrayList<RespuestaGroup> respuestas;
    private Grupo grupo;
    private RespuestaGroup respuestaGroup;

    @Test
    public void test01DadaUnaListaDeRespuestasSePreguntaSiUnaPertenecientePerteneceYDevuelveTrue(){
        respuestas = new ArrayList<>();
        respuestaGroup = new RespuestaGroup("Contenido");
        respuestas.add(respuestaGroup);
        grupo = new Grupo("Nombre Modelo.Grupo", respuestas);

        assertTrue(grupo.poseeRespuesta(respuestaGroup));
    }

    @Test
    public void test02DadaUnaListaDeRespuestasSePreguntaSiUnaNoPertenecientePerteneceYDevuelveFalse(){
        respuestas = new ArrayList<>();
        respuestaGroup = new RespuestaGroup("Contenido");
        respuestas.add(respuestaGroup);
        grupo = new Grupo("Nombre Modelo.Grupo", respuestas);
        respuestaGroup = new RespuestaGroup("Contenido2");

        assertFalse(grupo.poseeRespuesta(respuestaGroup));
    }



}
