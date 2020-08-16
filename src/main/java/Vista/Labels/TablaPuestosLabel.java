package Vista.Labels;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class TablaPuestosLabel extends Label {

    public TablaPuestosLabel(){
        super("Tabla de posiciones");
        setFont(Font.font("Arial", FontWeight.BOLD ,30));
        setAlignment(Pos.CENTER);
        setPadding(new Insets(100));
    }
}
