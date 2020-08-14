package Vista.Labels;

import Modelo.Jugador.Jugador;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class LabelTurnoJugador extends Label {
    public LabelTurnoJugador(Jugador jugadorTurno) {
        super("Turno de: " + jugadorTurno.getNombre());
        setFont(new Font("Arial", 20));
    }
}
