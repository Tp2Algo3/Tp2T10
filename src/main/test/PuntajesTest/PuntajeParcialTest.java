package PuntajesTest;

import Modelo.Puntajes.PuntajeParcial;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuntajeParcialTest {
    PuntajeParcial puntajeParcial;

    @Test
    public void test01ElUsuarioAciertaTodasLasRespuestas(){
        puntajeParcial = new PuntajeParcial();
        int puntos = puntajeParcial.calcularPuntaje(3,3,3);
        assertEquals(3,puntos);
    }

    @Test
    public void test02ElUsuarioAciertaAlgunasRespuestas(){
        puntajeParcial = new PuntajeParcial();
        int puntos = puntajeParcial.calcularPuntaje(2,3,2);
        assertEquals(2,puntos);
    }

    @Test
    public void test03ElUsuarioNoAciertaNingunaRespuestas(){
        puntajeParcial = new PuntajeParcial();
        int puntos = puntajeParcial.calcularPuntaje(0,3,0);
        assertEquals(0,puntos);
    }

    @Test
    public void test04ElUsuarioErraAlgunaRespuesta(){
        puntajeParcial = new PuntajeParcial();
        int puntos = puntajeParcial.calcularPuntaje(2,3,3);
        assertEquals(0,puntos);
    }
}
