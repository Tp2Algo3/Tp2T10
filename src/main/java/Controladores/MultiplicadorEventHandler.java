package Controladores;

import Jugador.Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class MultiplicadorEventHandler implements EventHandler<ActionEvent> {

    private Jugador jugador;
    private int id;

    public MultiplicadorEventHandler(Jugador jugador, int id){
        this.jugador = jugador;
        this.id = id;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        jugador.utilizarMultiplicador(this.id);
    }
}
