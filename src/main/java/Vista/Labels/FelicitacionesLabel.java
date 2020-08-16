package Vista.Labels;

import Modelo.Jugador.Jugador;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class FelicitacionesLabel extends Label {
    public FelicitacionesLabel(Jugador jugador) {
        super ("Felicitaciones " + jugador.getNombre() + ". Eres el ganador con: " + jugador.getPuntos() + " Puntos!!");
        setFont(Font.font("Arial", FontWeight.BOLD, 25));
        setPadding(new Insets(50,0,50,0));
        setStyle("-fx-text-fill: coral");
    }
}
