package PotenciadoresTest;

import Modelo.Potenciadores.MultiplicadorPorTres;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultiplicadorPorTresTest {
    MultiplicadorPorTres multiplicador;

    @Test
    public void test01DadoUnNumeroPositivoDevuelveElTripleDelNumero(){
        int resultado;

        multiplicador = new MultiplicadorPorTres();
        resultado = multiplicador.multiplicarPuntos(2);
        assertEquals(6,resultado);
    }
    @Test
    public void test02DadoUnNumeroNegativoDevueleElTripleDelNumero(){
        int resultado;

        multiplicador = new MultiplicadorPorTres();
        resultado = multiplicador.multiplicarPuntos(-1);
        assertEquals(-3,resultado);
    }

    @Test
    public void test03DadoCeroSeDevolveraCero(){
        int resultado;

        multiplicador = new MultiplicadorPorTres();
        resultado = multiplicador.multiplicarPuntos(0);
        assertEquals(0,resultado);
    }
}
