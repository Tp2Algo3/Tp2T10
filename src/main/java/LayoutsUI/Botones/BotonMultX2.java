package LayoutsUI.Botones;

import Controladores.MultiplicadorEventHandler;
import Jugador.Jugador;
import PatronObserver.Observer;
import javafx.scene.control.Button;

public class BotonMultX2 extends Button implements Observer {

    private Jugador jugador;

    public BotonMultX2(Jugador jugador){
        super("x2");
        this.jugador = jugador;
        setOnAction(new MultiplicadorEventHandler(jugador, this, 2));
        jugador.agregarObservador(this);
    }

    @Override
    public void actualizar() {
        if(jugador.getMultiplicadorActual().getId()!=1) {
            setDisable(true);
        }
    }
}
