package Vista.Boxes;

import Modelo.Preguntas.Pregunta;
import Modelo.Preguntas.PreguntaOpcionMultiple;
import Modelo.Preguntas.PreguntaOrderedChoice;
import Modelo.Preguntas.PreguntaVerdaderoOFalso;
import Vista.Labels.LabelPregunta;
import Vista.Labels.LabelTipoPregunta;
import Vista.Labels.LabelTipoPuntaje;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class PreguntaBox extends VBox {

    public PreguntaBox(Pregunta pregunta){
        Label tipoPregunta = new LabelTipoPregunta(pregunta);
        Label preguntaTexto = new LabelPregunta(pregunta.getContenido());
        Label tipoPuntajeTexto = new LabelTipoPuntaje(pregunta.getTipoPuntaje());
        getChildren().addAll(tipoPregunta,tipoPuntajeTexto,preguntaTexto);
        setAlignment(Pos.CENTER);
        setSpacing(20);
    }
}
