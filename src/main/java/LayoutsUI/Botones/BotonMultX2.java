package LayoutsUI.Botones;

import Controladores.MultiplicadorEventHandler;
import Jugador.Jugador;
import PatronObserver.Observer;
import javafx.scene.control.Button;

public class BotonMultX2 extends Button implements Observer {

    public BotonMultX2(Jugador jugador){
        super("x2");
        setOnAction(new MultiplicadorEventHandler(jugador, this, 2));
        jugador.agregarObservador(this);
    }

    @Override
    public void actualizar() {
        setDisable(true);
    }
}
