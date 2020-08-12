package Vista.Labels;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class LabelPregunta extends Label {

    public LabelPregunta(String contenido){
        super(contenido);
        setFont(new Font("Arial", 20));
    }
}
