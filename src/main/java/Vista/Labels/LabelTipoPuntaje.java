package Vista.Labels;

import Modelo.Puntajes.Puntaje;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class LabelTipoPuntaje extends Label {

    public LabelTipoPuntaje(Puntaje puntaje){
        super(puntaje.getNombre());
        setFont(new Font("Arial", 20));
    }
}
