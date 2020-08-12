package Vista.Labels;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class TituloInicio extends Label {
    public TituloInicio() {
        super("Bienvenidos al Kahoot! del grupo T10.");
        setFont(new Font("Arial", 30));
        setPadding(new Insets(100, 0, 100, 0));
    }
}
