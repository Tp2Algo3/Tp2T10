package Controladores;

import Modelo.Jugador.Jugador;
import Modelo.Potenciadores.Multiplicador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class MultiplicadorEventHandler implements EventHandler<ActionEvent> {

    private Jugador jugador;
    private Multiplicador multiplicador;

    public MultiplicadorEventHandler(Jugador jugador, Multiplicador multiplicador){
        this.jugador = jugador;
        this.multiplicador = multiplicador;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        jugador.utilizarMultiplicador(this.multiplicador);
    }
}
