package Vista.Labels;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class TituloInicio extends Label {
    public TituloInicio() {
        super("Bienvenidos al Kahoot! del grupo T10.");
        setFont(Font.font("Arial", FontWeight.BOLD,30));
        setPadding(new Insets(100, 0, 100, 0));
    }
}
