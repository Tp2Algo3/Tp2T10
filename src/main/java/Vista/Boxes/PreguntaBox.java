package Vista.Boxes;

import Modelo.Preguntas.Pregunta;
import Vista.Labels.LabelPregunta;
import Vista.Labels.LabelTipoPuntaje;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class PreguntaBox extends VBox {

    public PreguntaBox(Pregunta pregunta){
        Label preguntaTexto = new LabelPregunta(pregunta.getContenido());
        Label tipoPuntajeTexto = new LabelTipoPuntaje(pregunta.getTipoPuntaje());
        getChildren().add(preguntaTexto);
        getChildren().add(tipoPuntajeTexto);
        setAlignment(Pos.CENTER);
    }
}
