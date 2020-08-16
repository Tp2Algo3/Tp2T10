package Vista.Boxes;

import Modelo.Jugador.Jugador;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

import java.util.ArrayList;

public class JugadoresConSusPuntajes extends VBox{

    public JugadoresConSusPuntajes(ArrayList<Jugador> jugadores) {
        VBox contenido = new VBox();
        Label titulo = new Label("Jugadores");
        titulo.setFont(Font.font("Arial", FontPosture.ITALIC, 18));
        titulo.setAlignment(Pos.CENTER);
        contenido.getChildren().add(titulo);

        for (Jugador jugador : jugadores) {
            Label label_j = new Label(jugador.getNombre() + ": " + jugador.getPuntos());
            contenido.getChildren().add(label_j);
            label_j.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        }
        contenido.setAlignment(Pos.CENTER);
        contenido.setSpacing(5);
        getChildren().add(contenido);
        setAlignment(Pos.TOP_LEFT);
    }
}
