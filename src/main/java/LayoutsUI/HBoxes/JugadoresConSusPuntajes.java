package LayoutsUI.HBoxes;

import Jugador.Jugador;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.util.ArrayList;

public class JugadoresConSusPuntajes extends HBox{

    public JugadoresConSusPuntajes(ArrayList<Jugador> jugadores) {
        for (Jugador jugador : jugadores) {
            Label label_j = new Label(jugador.getNombre() + ": " + jugador.getPuntos());
            getChildren().add(label_j);
        }
        setSpacing(600);
        setAlignment(Pos.CENTER);
    }
}
