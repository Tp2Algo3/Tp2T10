package Potenciadores;

import Jugador.Potenciadores.MultiplicadorDefecto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultiplicadorDefectoTest {
    MultiplicadorDefecto multiplicador;

    @Test
    public void test00DadoUnNumeroPositivoDevuelveElMismoNumero(){
        int resultado;

        multiplicador = new MultiplicadorDefecto();
        resultado = multiplicador.multiplicarPuntos(2);
        assertEquals(2,resultado);
    }
    @Test
    public void test01DadoUnNumeroNegativoDevueleElMismoNumero(){
        int resultado;

        multiplicador = new MultiplicadorDefecto();
        resultado = multiplicador.multiplicarPuntos(-2);
        assertEquals(-2,resultado);
    }

    @Test
    public void test02DadoCeroSeDevolveraCero(){
        int resultado;

        multiplicador = new MultiplicadorDefecto();
        resultado = multiplicador.multiplicarPuntos(0);
        assertEquals(0,resultado);
    }
}
