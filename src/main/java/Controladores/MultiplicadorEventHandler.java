package Controladores;

import Jugador.Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class MultiplicadorEventHandler implements EventHandler<ActionEvent> {

    private Jugador jugador;
    private Button boton;
    private int id;

    public MultiplicadorEventHandler(Jugador jugador, Button button, int id){
        this.jugador = jugador;
        this.boton = button;
        this.id = id;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        jugador.utilizarMultiplicador(this.id);
    }
}
