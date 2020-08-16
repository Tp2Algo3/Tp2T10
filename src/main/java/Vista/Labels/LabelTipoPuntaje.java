package Vista.Labels;

import Modelo.Puntajes.Puntaje;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class LabelTipoPuntaje extends Label {

    public LabelTipoPuntaje(Puntaje puntaje){
        super(puntaje.getNombre());
        setFont(Font.font("Arial", FontWeight.BOLD,20));
        setStyle("-fx-text-fill: #fdcf58");
    }
}
