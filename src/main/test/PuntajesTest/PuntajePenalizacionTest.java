package PuntajesTest;

import Modelo.Puntajes.PuntajePenalizacion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuntajePenalizacionTest {
    PuntajePenalizacion puntajePenalizacion;

    @Test
    public void test01ElUsuarioAciertaTodasLasRespuestas(){
        puntajePenalizacion = new PuntajePenalizacion();
        int puntos = puntajePenalizacion.calcularPuntaje(3,3,3);
        assertEquals(3,puntos);
    }

    @Test
    public void test02ElUsuarioAciertaAlgunasRespuestas(){
        puntajePenalizacion = new PuntajePenalizacion();
        int puntos = puntajePenalizacion.calcularPuntaje(2,3,2);
        assertEquals(0,puntos);
    }

    @Test
    public void test03ElUsuarioNoAciertaNingunaRespuestas(){
        puntajePenalizacion = new PuntajePenalizacion();
        int puntos = puntajePenalizacion.calcularPuntaje(0,3,0);
        assertEquals(0,puntos);
    }

    @Test
    public void test04ElUsuarioErraAlgunaRespuesta(){
        puntajePenalizacion = new PuntajePenalizacion();
        int puntos = puntajePenalizacion.calcularPuntaje(1,3,3);
        assertEquals(-2,puntos);
    }
}
