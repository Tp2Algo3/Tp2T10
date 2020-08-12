package Vista.Labels;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class TablaPuestosLabel extends Label {

    public TablaPuestosLabel(){
        super("Tabla de posiciones");
        setFont(new Font("Arial", 30));
        setAlignment(Pos.CENTER);
        setPadding(new Insets(100));
    }
}
