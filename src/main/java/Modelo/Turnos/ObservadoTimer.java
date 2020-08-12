package Modelo.Turnos;

import PatronObserver.Observado;
import PatronObserver.Observer;

import java.util.ArrayList;

public class ObservadoTimer extends Observado {

    public ObservadoTimer(){
        observadores = new ArrayList<>();
    }
}
