package Vista.Botones;

import Controladores.BotonJugarEventHandler;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class BotonJugar extends Button {
    public BotonJugar(ArrayList<TextField> nombresJugadores) {
        super("Jugar");
        setOnAction(new BotonJugarEventHandler(nombresJugadores));
        setPrefSize(100,50);
        setCursor(Cursor.HAND);
    }
}
