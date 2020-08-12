package Vista.Boxes;

import Vista.Labels.LabelPregunta;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class PreguntaBox extends HBox {

    public PreguntaBox(String contenidoPregunta){
        Label preguntaTexto = new LabelPregunta(contenidoPregunta);
        getChildren().add(preguntaTexto);
        setAlignment(Pos.CENTER);
    }
}
