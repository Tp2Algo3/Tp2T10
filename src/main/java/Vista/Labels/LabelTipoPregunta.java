package Vista.Labels;

import Modelo.Preguntas.Pregunta;
import Modelo.Preguntas.PreguntaOpcionMultiple;
import Modelo.Preguntas.PreguntaOrderedChoice;
import Modelo.Preguntas.PreguntaVerdaderoOFalso;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class LabelTipoPregunta extends Label {

    public LabelTipoPregunta(Pregunta pregunta){
        if (pregunta.getClass() == PreguntaVerdaderoOFalso.class){
            setText("Pregunta Verdadero o Falso");
        }
        else if (pregunta.getClass() == PreguntaOpcionMultiple.class){
            setText("Pregunta Multiple Choice");
        }
        else if (pregunta.getClass() == PreguntaOrderedChoice.class){
            setText("Pregunta Ordered Choice");
        }
        else{
            setText("Pregunta Group Choice");
        }
        setFont(Font.font("Arial", FontWeight.BOLD,20));
        setStyle("-fx-text-fill: #fdcf58");
    }
}
