package LayoutsUI.Botones;

import Controladores.MultiplicadorEventHandler;
import Jugador.Jugador;
import PatronObserver.Observer;
import javafx.scene.control.Button;

public class BotonMultX3 extends Button implements Observer {

    public BotonMultX3(Jugador jugador){
        super("x3");
        setOnAction(new MultiplicadorEventHandler(jugador, this, 3));
        jugador.agregarObservador(this);
    }

    @Override
    public void actualizar(){
        setDisable(true);
    }
}