package Vista.Labels;

import Modelo.Jugador.Jugador;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class FelicitacionesLabel extends Label {
    public FelicitacionesLabel(Jugador jugador) {
        super ("Felicitaciones " + jugador.getNombre() + ". Eres el ganador con: " + jugador.getPuntos() + " Puntos!!");
        setFont(new Font("Arial", 20));
        setPadding(new Insets(50,0,50,0));
    }
}
