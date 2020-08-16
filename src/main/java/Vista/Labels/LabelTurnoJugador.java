package Vista.Labels;

import Modelo.Jugador.Jugador;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class LabelTurnoJugador extends Label {
    public LabelTurnoJugador(Jugador jugadorTurno) {
        super("Turno de: " + jugadorTurno.getNombre());
        setFont(Font.font("Arial", FontWeight.BOLD,20));
    }
}
