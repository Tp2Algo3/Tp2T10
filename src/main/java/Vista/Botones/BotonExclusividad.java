package Vista.Botones;

import Controladores.UsarExclusividadEventHandler;
import Modelo.Jugador.Jugador;
import Modelo.Preguntas.Pregunta;
import javafx.scene.Cursor;
import javafx.scene.control.Button;

public class BotonExclusividad extends Button {
    public BotonExclusividad(Jugador jugador, Pregunta pregunta){
        super ("Excl.");
        setOnAction(new UsarExclusividadEventHandler(jugador, pregunta, this));
        setCursor(Cursor.HAND);
    }
}
