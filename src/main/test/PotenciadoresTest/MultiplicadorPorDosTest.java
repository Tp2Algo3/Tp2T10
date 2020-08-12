package PotenciadoresTest;

import Modelo.Potenciadores.MultiplicadorPorDos;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultiplicadorPorDosTest {
    MultiplicadorPorDos multiplicador;

    @Test
    public void test01DadoUnNumeroPositivoDevuelveElDobleDelNumero(){
        int resultado;

        multiplicador = new MultiplicadorPorDos();
        resultado = multiplicador.multiplicarPuntos(2);
        assertEquals(4,resultado);
    }
    @Test
    public void test02DadoUnNumeroNegativoDevueleElDobleDelNumero(){
        int resultado;

        multiplicador = new MultiplicadorPorDos();
        resultado = multiplicador.multiplicarPuntos(-1);
        assertEquals(-2,resultado);
    }

    @Test
    public void test03DadoCeroSeDevolveraCero(){
        int resultado;

        multiplicador = new MultiplicadorPorDos();
        resultado = multiplicador.multiplicarPuntos(0);
        assertEquals(0,resultado);
    }

}
