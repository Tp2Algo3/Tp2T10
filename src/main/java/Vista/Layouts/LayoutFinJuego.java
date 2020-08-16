package Vista.Layouts;

import Modelo.Jugador.Jugador;
import Vista.Boxes.PuestosVBox;
import Vista.Labels.FelicitacionesLabel;
import Vista.Labels.TablaPuestosLabel;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class LayoutFinJuego {

    public static StackPane getLayout(ArrayList<Jugador> jugadores){
        StackPane layout = new StackPane();
        VBox verticalLayout = new VBox();
        Label tablaPuestos = new TablaPuestosLabel();
        Label felicitaciones = new FelicitacionesLabel(jugadores.get(0));
        VBox puestos = new PuestosVBox(jugadores);
        verticalLayout.getChildren().addAll(tablaPuestos, felicitaciones, puestos);
        verticalLayout.setAlignment(Pos.TOP_CENTER);
        layout.getChildren().add(verticalLayout);
        layout.setAlignment(Pos.TOP_CENTER);
        layout.setStyle("-fx-background-color: #fff7a9");
        return layout;
    }
}
