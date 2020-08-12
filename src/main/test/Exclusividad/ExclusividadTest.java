package Exclusividad;

import Modelo.Potenciadores.ExclusividadPuntaje;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExclusividadTest {

    ExclusividadPuntaje exclusividad;
    ArrayList <Boolean> contestaronBien;
    ArrayList <Integer> puntajes;

    @Test
    public void test01TodosLosJugadoresRespondenCorrectamenteYExclusividadNoDaPuntos(){
        exclusividad = new ExclusividadPuntaje();
        contestaronBien = new ArrayList<>();
        puntajes = new ArrayList<>();

        puntajes.add(2);
        puntajes.add(2);
        contestaronBien.add(true);
        contestaronBien.add(true);

        exclusividad.multiplicarPuntos(puntajes,contestaronBien);
        assertEquals(0,puntajes.get(0));
        assertEquals(0,puntajes.get(1));
    }

    @Test
    public void test02UnJugadorRespondeCorrectamenteSoloSeMultiplicanSusPuntos(){
        exclusividad = new ExclusividadPuntaje();
        contestaronBien = new ArrayList<>();
        puntajes = new ArrayList<>();

        puntajes.add(1);
        puntajes.add(4);
        contestaronBien.add(false);
        contestaronBien.add(true);

        exclusividad.multiplicarPuntos(puntajes,contestaronBien);
        assertEquals(1,puntajes.get(0));
        assertEquals(8,puntajes.get(1));
    }

    @Test
    public void test03AmbosJugadoresContestanErroneamenteYNoSeMultiplicanSusPuntos(){
        exclusividad = new ExclusividadPuntaje();
        contestaronBien = new ArrayList<>();
        puntajes = new ArrayList<>();

        puntajes.add(1);
        puntajes.add(4);
        contestaronBien.add(false);
        contestaronBien.add(false);

        exclusividad.multiplicarPuntos(puntajes,contestaronBien);
        assertEquals(1,puntajes.get(0));
        assertEquals(4,puntajes.get(1));
    }
}
