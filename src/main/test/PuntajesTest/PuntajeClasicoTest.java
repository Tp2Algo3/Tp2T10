package PuntajesTest;

import Modelo.Puntajes.PuntajeClasico;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuntajeClasicoTest {

    PuntajeClasico puntajeClasico;

    @Test
    public void test01ElUsuarioAciertaTodasLasRespuestas(){
        puntajeClasico = new PuntajeClasico();
        int puntos = puntajeClasico.calcularPuntaje(3,3,3);
        assertEquals(1,puntos);
    }

    @Test
    public void test02ElUsuarioAciertaAlgunasRespuestas(){
        puntajeClasico = new PuntajeClasico();
        int puntos = puntajeClasico.calcularPuntaje(2,3,2);
        assertEquals(0,puntos);
    }

    @Test
    public void test03ElUsuarioNoAciertaNingunaRespuestas(){
        puntajeClasico = new PuntajeClasico();
        int puntos = puntajeClasico.calcularPuntaje(0,3,0);
        assertEquals(0,puntos);
    }

    @Test
    public void test04ElUsuarioErraAlgunaRespuesta(){
        puntajeClasico = new PuntajeClasico();
        int puntos = puntajeClasico.calcularPuntaje(2,3,3);
        assertEquals(0,puntos);
    }
}
